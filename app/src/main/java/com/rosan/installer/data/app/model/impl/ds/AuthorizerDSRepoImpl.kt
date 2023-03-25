package com.rosan.installer.data.app.model.impl.ds

import com.rosan.installer.data.app.repo.ds.ConsoleDSRepo
import com.rosan.installer.data.console.repo.ConsoleRepo
import com.rosan.installer.data.console.util.ConsoleRepoUtil
import com.rosan.installer.data.settings.model.room.entity.ConfigEntity

class AuthorizerDSRepoImpl : ConsoleDSRepo {
    override suspend fun loadConsole(
        config: ConfigEntity,
        packageName: String,
        className: String,
        enabled: Boolean
    ): ConsoleRepo = when (config.authorizer) {
        ConfigEntity.Authorizer.None -> ConsoleRepoUtil.sh { }
        ConfigEntity.Authorizer.Root -> ConsoleRepoUtil.system { }
        ConfigEntity.Authorizer.Shizuku -> ConsoleRepoUtil.shizuku { }
        ConfigEntity.Authorizer.Customize -> ConsoleRepoUtil.open {
            this.command(config.customizeAuthorizer)
        }
    }
}