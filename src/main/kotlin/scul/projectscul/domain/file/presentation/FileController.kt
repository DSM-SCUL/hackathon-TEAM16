package scul.projectscul.domain.file.presentation

import jakarta.validation.constraints.NotNull
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import scul.projectscul.domain.file.presentation.response.UploadFileResponse
import scul.projectscul.domain.user.presentation.request.SignUpRequest
import scul.projectscul.global.redis.dto.TokenResponse
import scul.projectscul.infra.FileUploadService
import java.io.File
import java.io.FileOutputStream
import java.util.*

@RequestMapping("/scul/files")
@RestController
class FileController (
        private val fileUploadService: FileUploadService
) {

    @PostMapping("/upload")
    fun uploadFile(@RequestPart @NotNull file: MultipartFile?): UploadFileResponse {
        val result = fileUploadService.execute(
                file!!.toFile()
        )
        return UploadFileResponse(result)
    }

    fun MultipartFile.toFile() =
            File("${UUID.randomUUID()}||$originalFilename").let {
                FileOutputStream(it).run {
                    this.write(bytes)
                    this.close()
                }
                it
            }

}