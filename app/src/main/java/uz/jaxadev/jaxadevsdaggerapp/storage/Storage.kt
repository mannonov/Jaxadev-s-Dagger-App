package uz.jaxadev.jaxadevsdaggerapp.storage

interface Storage {
    fun setString(key: String, value: String)
    fun getString(key: String): String
}
