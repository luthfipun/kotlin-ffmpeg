# Documentation

The kotlin's application implemented ffmpeg library to convert or manipulating video, this sample only just cropping video to 300x300 pixel.

## Usage

> Please install ffmpeg library on your device and run the applications

- Put your video url directly on ``.setFileName()`` function
- Fill the output name on ``.setOutputName()`` function, recommended is unique
- And, You can listen callback from the ffmpeg converter is completed or errors
- The result will be saved on this project with folder name ``ffmpeg/out``

This for example :

```kotlin
val videoCropping = VideoCropping.Builder()
        .setFileName(fileUrl = fileURL)
        .setOutputName(outputName = outputName)
        .build()

videoCropping.startCrop(object : VideoCroppingListener {
    override fun onComplete() {
        println("Crop completed!")
    }

    override fun onError(e: Exception) {
        println("Crop error : ${e.message}")
    }
})
```