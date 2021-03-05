package ink.ptms.chemdah.database

import ink.ptms.chemdah.core.PlayerProfile
import org.bukkit.entity.Player

/**
 * Chemdah
 * ink.ptms.chemdah.core.database.Database
 *
 * @author sky
 * @since 2021/3/3 4:39 下午
 */
interface Database {

    /**
     * 从数据库拉取玩家数据
     */
    fun select(player: Player): PlayerProfile

    /**
     * 将玩家数据写入数据库
     */
    fun update(player: Player, playerProfileProfile: PlayerProfile)

    companion object {

        val INSTANCE: Database by lazy {
            when (Type.INSTANCE) {
                Type.SQL -> DatabaseSQL()
                Type.LOCAL -> DatabaseLocal()
                Type.MONGODB -> DatabaseMongoDB()
            }
        }
    }
}