package com.rosan.installer.data.installer.model.entity

import com.rosan.installer.data.app.model.entity.AppEntity

data class InstallEntity(
    val app: AppEntity,
    val selected: Boolean
)