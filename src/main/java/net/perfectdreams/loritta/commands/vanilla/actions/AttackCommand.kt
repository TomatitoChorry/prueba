package net.perfectdreams.loritta.commands.vanilla.actions

import com.mrpowergamerbr.loritta.Loritta
import com.mrpowergamerbr.loritta.utils.locale.BaseLocale
import net.dv8tion.jda.core.entities.User

class AttackCommand : ActionCommand(arrayOf("attack", "atacar")) {
    override fun getDescription(locale: BaseLocale): String {
        return locale["commands.actions.attack.description"]
    }

    override fun getResponse(locale: BaseLocale, first: User, second: User): String {
        return if (second.id != Loritta.config.clientId) {
            locale["commands.actions.attack.response", first.asMention, second.asMention]
        } else {
            locale["commands.actions.attack.responseAntiIdiot", second.asMention, first.asMention]
        }
    }

    override fun getFolderName(): String {
        return "attack"
    }

    override fun getEmoji(): String {
        return "\uD83E\uDD4A"
    }
}