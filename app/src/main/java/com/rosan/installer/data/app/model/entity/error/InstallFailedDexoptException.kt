package com.rosan.installer.data.app.model.entity.error

class InstallFailedDexoptException : Exception {
    constructor() : super()

    constructor(message: String?) : super(message)
}