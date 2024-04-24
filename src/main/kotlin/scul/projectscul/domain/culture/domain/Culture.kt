package scul.projectscul.domain.culture.domain

import com.example.kotlinpractice.global.entity.BaseUUIDEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import scul.projectscul.domain.culture.domain.enum.CultureType
import java.util.*

@Entity
class Culture (
        id: UUID?,

        //지역명 (구로시)
        val location: String,

        //이미지 url
        val imageUrl: String,

        //장소 (서울 특별시 대공원)
        val placeName: String,

        //서비스 대상 ex) 장애인(중고등학교 특수학급 단체)
        val wantedPeople: String,

        //서비스명 ex)느낌 있는 박물관> 교육생 모집 안내
        @Column(columnDefinition = "VARCHAR(50)", nullable = true)
        val cultureName: String,

        //상세내용
        @Column(columnDefinition = "TEXT")
        val content: String,

        //전화 번호
        @Column(columnDefinition = "VARCHAR(50)", nullable = true)
        val phoneNumber: String,

        //서비스 개시 시작일시
        val applicationStartDate: String,

        //서비스 개시 시작일시
        val applicationEndDate: String,

        //서비스 개시 시작일시
        val serviceStartDate: String,

        //서비스 개시 시작일시
        val serviceEndDate: String,

        //입장료
        @Column(nullable = true)
        val ticketPrice: String,

        //바로가기 url
        @Column(columnDefinition = "VARCHAR(100)", nullable = true)
        val cultureLink: String,

        //y 좌표
        @Column(columnDefinition = "DOUBLE", nullable = true)
        val xCoordinate: Double,

        //y좌표
        @Column(columnDefinition = "DOUBLE", nullable = true)
        val yCoordinate: Double,

        //북마크 되어있는지
        @Column
        val isBookMarked: Boolean = false

) : BaseUUIDEntity(id)
