package github.luthfipun.kotlinffmpeg

import github.luthfipun.kotlinffmpeg.Constant.ffmpegPath

class VideoCropping private constructor(
    val fileUrl: String?,
    val outputName: String?
){
    data class Builder(
        var fileUrl: String? = null,
        var outputName: String? = null
    ){
      fun setFileName(fileUrl: String) = apply { this.fileUrl = fileUrl }
      fun setOutputName(outputName: String) = apply { this.outputName = outputName }
      fun build() = apply { VideoCropping(fileUrl, outputName) }

      fun startCrop(videoCroppingListener: VideoCroppingListener){

          if (fileUrl.isNullOrBlank()){
              videoCroppingListener.onError(IllegalArgumentException("file url is not empty!"))
              return
          }

          if (outputName.isNullOrBlank()){
              videoCroppingListener.onError(IllegalArgumentException("output name is not empty"))
              return
          }

          val command = "ffmpeg -i $fileUrl -filter:v crop=300:300 $ffmpegPath/out/${outputName}.mp4"

          try {
              val process: Process = Runtime.getRuntime().exec(command)
              if (process.waitFor() == 0){
                  videoCroppingListener.onComplete()
              }
          }catch (e: Exception){
              videoCroppingListener.onError(e)
          }
      }
    }
}