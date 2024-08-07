package scul.projectscul.infra

import com.amazonaws.HttpMethod
import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.services.s3.AmazonS3Client
import com.amazonaws.services.s3.AmazonS3ClientBuilder
import com.amazonaws.services.s3.internal.Mimetypes
import com.amazonaws.services.s3.model.CannedAccessControlList
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest
import com.amazonaws.services.s3.model.ObjectMetadata
import com.amazonaws.services.s3.model.PutObjectRequest
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import scul.projectscul.domain.user.exception.UserNotFoundException
import java.io.File
import java.io.IOException
import java.sql.Timestamp
import java.time.LocalDateTime

@Component
class AwsS3Adapter(
    private val awsProperties: AwsS3Properties,
    private val amazonS3Client: AmazonS3Client
)  {

    fun upload(file: File): String {
        inputS3(file, file.name)

        return getResourceUrl(file.name)
    }

    private fun inputS3(file: File, fileName: String) {
        try {
            val inputStream = file.inputStream()
            val objectMetadata = ObjectMetadata().apply {
                this.contentLength = file.length()
                this.contentType = Mimetypes.getInstance().getMimetype(file)
            }

            amazonS3Client.putObject(
                PutObjectRequest(awsProperties.bucket, fileName, inputStream, objectMetadata)
                    .withCannedAcl(
                        CannedAccessControlList.PublicRead
                    )
            )

            file.delete()
        } catch (e: IOException) {
            throw UserNotFoundException
        }
    }

    fun getResourceUrl(fileName: String): String {
        return amazonS3Client.getResourceUrl(awsProperties.bucket, fileName)
    }

    fun getUploadUrl(fileName: String): String {

        val generatePresignedUrlRequest =
            GeneratePresignedUrlRequest(awsProperties.bucket, fileName)
                .withMethod(HttpMethod.PUT)
                .withExpiration(Timestamp.valueOf(LocalDateTime.now().plusHours(4)))

        return amazonS3Client.generatePresignedUrl(generatePresignedUrlRequest).toString()
    }
}
