package scul.projectscul.infra.open.dto
data class ApiResponse(
        val ListPublicReservationCulture: ResponseBody
)

data class ResponseBody(
        val list_total_count: Int,
        val RESULT: ApiResult,
        val row: List<Culture>
)

data class ApiResult(
        val CODE: String,
        val MESSAGE: String
)

data class Culture(
        val GUBUN: String,
        val SVCID: String,
        val MAXCLASSNM: String,
        val MINCLASSNM: String,
        val SVCSTATNM: String,
        val SVCNM: String,
        val PAYATNM: String,
        val PLACENM: String,
        val USETGTINFO: String,
        val SVCURL: String,
        val X: String,
        val Y: String,
        val SVCOPNBGNDT: String,
        val SVCOPNENDDT: String,
        val RCPTBGNDT: String,
        val RCPTENDDT: String,
        val AREANM: String,
        val IMGURL: String,
        val DTLCONT: String,
        val TELNO: String,
        val V_MIN: String,
        val V_MAX: String,
        val REVSTDDAYNM: String,
        val REVSTDDAY: String
)

data class Culture2(
        val svcid: String,
        val svcnm: String,
        val gubun: String
        // 다른 필드들을 추가할 수 있습니다.
)