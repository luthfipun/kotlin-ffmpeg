package github.luthfipun.kotlinffmpeg

interface VideoCroppingListener {
    fun onComplete()
    fun onError(e: Exception)
}