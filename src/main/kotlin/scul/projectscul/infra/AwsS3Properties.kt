package scul.projectscul.infra

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class AwsS3Properties(
    @Value("\${cloud.aws.s3.bucket}")
    val bucket: String
)
