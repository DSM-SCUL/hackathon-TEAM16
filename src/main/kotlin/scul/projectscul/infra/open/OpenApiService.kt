package scul.projectscul.infra.open

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.w3c.dom.Element
import org.w3c.dom.Node
import scul.projectscul.domain.culture.domain.Culture
import scul.projectscul.domain.culture.domain.repository.CultureRepository
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import javax.xml.parsers.DocumentBuilderFactory


@Service
class OpenApiService (
        private val cultureRepository: CultureRepository
) {
    suspend fun execute() {
        cultureRepository.deleteAll()
        fetchCultures()
    }

    private suspend fun fetchCultures(): ResponseEntity<String> {
        val apiKey = "4e724e637a31323138375478514353"  // 인증키
        val fileType = "xml"  // 요청 파일 타입
        val serviceName = "ListPublicReservationCulture"  // 서비스명
        val startIndex = "1"  // 요청 시작 위치
        val endIndex = "1"  // 요청 종료 위치
        val urlBuilder = "http://openAPI.seoul.go.kr:8088/4e724e637a31323138375478514353/xml/ListPublicReservationCulture/1/5/"

        // URL 연결 설정
        val url = URL(urlBuilder)
        val conn = url.openConnection() as HttpURLConnection
        conn.requestMethod = "GET"
        conn.setRequestProperty("Content-type", "application/xml")

        val reader = if (conn.responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader(InputStreamReader(conn.inputStream))
        } else {
            BufferedReader(InputStreamReader(conn.errorStream))
        }

        val response = StringBuilder()
        var line: String?
        while (reader.readLine().also { line = it } != null) {
            response.append(line)
        }
        reader.close()

        parseAndSaveCulture(response.toString())
        return ResponseEntity.ok("Cultures fetched and saved successfully")
    }

    private fun parseAndSaveCulture(response: String) {
        val docBuilderFactory = DocumentBuilderFactory.newInstance()
        val docBuilder = docBuilderFactory.newDocumentBuilder()
        val doc = docBuilder.parse(response.byteInputStream())

        val nodeList = doc.getElementsByTagName("row")
        for (i in 0 until nodeList.length) {
            if (nodeList.item(i).nodeType == Node.ELEMENT_NODE) {
                val element = nodeList.item(i) as Element

                val culture = Culture(
                        id = null,
                        applicationStartDate = element.getElementsByTagName("RCPTBGNDT").item(0).textContent,
                        applicationEndDate = element.getElementsByTagName("RCPTENDDT").item(0).textContent,
                        serviceStartDate = element.getElementsByTagName("SVCOPNBGNDT").item(0).textContent,
                        serviceEndDate = element.getElementsByTagName("SVCOPNENDDT").item(0).textContent,
                        cultureName = element.getElementsByTagName("SVCNM").item(0).textContent,
                        ticketPrice = element.getElementsByTagName("PAYATNM").item(0).textContent,
                        placeName = element.getElementsByTagName("PLACENM").item(0).textContent,
                        wantedPeople = element.getElementsByTagName("USETGTINFO").item(0).textContent,
                        cultureLink = element.getElementsByTagName("SVCURL").item(0).textContent,
                        xCoordinate = element.getElementsByTagName("X").item(0).textContent.toDouble(),
                        yCoordinate = element.getElementsByTagName("Y").item(0).textContent.toDouble(),
                        location = element.getElementsByTagName("AREANM").item(0).textContent,
                        imageUrl = element.getElementsByTagName("IMGURL").item(0).textContent,
                        content = element.getElementsByTagName("DTLCONT").item(0).textContent,
                        phoneNumber = element.getElementsByTagName("TELNO").item(0).textContent
                )

                cultureRepository.save(culture)
            }
        }
    }
}
