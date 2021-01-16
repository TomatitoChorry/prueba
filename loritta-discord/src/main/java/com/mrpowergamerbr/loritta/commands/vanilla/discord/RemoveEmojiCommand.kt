package com.mrpowergamerbr.loritta.commands.vanilla.discord

import com.mrpowergamerbr.loritta.commands.AbstractCommand
import com.mrpowergamerbr.loritta.commands.CommandContext
import com.mrpowergamerbr.loritta.utils.Constants
import com.mrpowergamerbr.loritta.utils.locale.BaseLocale
import net.dv8tion.jda.api.Permission
import net.perfectdreams.loritta.api.commands.CommandCategory
import net.perfectdreams.loritta.api.messages.LorittaReply

class RemoveEmojiCommand : AbstractCommand("removeemoji", listOf("deleteemoji", "deletaremoji", "removeremoji", "delemoji"), CommandCategory.DISCORD) {
	// TODO: Fix Usage

	override fun getDescription(locale: BaseLocale): String {
		return locale["commands.discord.removeemoji.description"]
	}

	override fun getDiscordPermissions(): List<Permission> {
		return listOf(Permission.MANAGE_EMOTES)
	}

	override fun getBotPermissions(): List<Permission> {
		return listOf(Permission.MANAGE_EMOTES)
	}

	override suspend fun run(context: CommandContext,locale: BaseLocale) {
		var deletedEmotes = 0

		context.message.emotes.forEach {
			if (it.guild == context.guild) {
				it.delete().queue()
				deletedEmotes++
			}
		}

		if (deletedEmotes != 0) {
			context.reply(
                    LorittaReply(
                            locale["commands.discord.removeemoji.success", deletedEmotes, if (deletedEmotes == 1) "emoji" else "emojis"],
                            "\uD83D\uDDD1"
                    )
			)
		} else {
			context.reply(
                    LorittaReply(
                            locale["commands.discord.removeemoji.noEmojiRemoved"],
                            Constants.ERROR
                    )
			)
		}
	}
}
