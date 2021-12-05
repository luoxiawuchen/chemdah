package ink.ptms.chemdah.core.quest.objective.bukkit

import ink.ptms.chemdah.core.quest.objective.Dependency
import ink.ptms.chemdah.core.quest.objective.ObjectiveCountableI
import org.bukkit.entity.Player
import org.bukkit.event.entity.HorseJumpEvent

/**
 * Chemdah
 * ink.ptms.chemdah.core.quest.objective.bukkit.IPlayerJump
 *
 * @author sky
 * @since 2021/3/2 5:09 下午
 */
@Dependency("minecraft")
object IPlayerJumpHorse : ObjectiveCountableI<HorseJumpEvent>() {

    override val name = "horse jump"
    override val event = HorseJumpEvent::class
    override val isAsync = true

    init {
        handler {
            entity.passengers[0] as? Player
        }
        addSimpleCondition("position") { e ->
            toPosition().inside(e.entity.location)
        }
        addSimpleCondition("entity") { e ->
            toInferEntity().isEntity(e.entity)
        }
        addSimpleCondition("power") { e ->
            toDouble() <= e.power
        }
        addConditionVariable("power") {
            it.power
        }
    }
}