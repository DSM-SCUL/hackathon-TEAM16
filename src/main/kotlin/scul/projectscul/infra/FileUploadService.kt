package scul.projectscul.infra

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.io.File

@Service
@Transactional(readOnly = true)
class FileUploadService (
        private val uploadService: AwsS3Adapter
) {
    fun execute(file: File): String {

        return uploadService.upload(file)
    }

}
