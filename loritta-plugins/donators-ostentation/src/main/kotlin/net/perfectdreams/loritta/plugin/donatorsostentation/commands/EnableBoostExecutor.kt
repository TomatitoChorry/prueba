package net.perfectdreams.loritta.plugin.donatorsostentation.commands

import net.perfectdreams.loritta.api.commands.CommandContext
import net.perfectdreams.loritta.api.messages.LorittaReply
import net.perfectdreams.loritta.commands.vanilla.magic.LoriToolsCommand
import net.perfectdreams.loritta.platform.discord.commands.DiscordCommandContext
import net.perfectdreams.loritta.platform.discord.entities.jda.JDAUser
import net.perfectdreams.loritta.plugin.donatorsostentation.NitroBoostUtils

object EnableBoostExecutor : LoriToolsCommand.LoriToolsExecutor {
	override val args = "donation boost enable <user>"

	override fun executes(): suspend CommandContext.() -> Boolean = task@{
		if (this.args.getOrNull(0) != "donation")
			return@task false
		if (this.args.getOrNull(1) != "boost")
			return@task false
		if (this.args.getOrNull(2) != "enable")
			return@task false

		val context = this.checkType<DiscordCommandContext>(this)

		val user = context.user(3) ?: run {
			context.sendMessage("Usuário inexistente!")
			return@task true
		}
		user as JDAUser

		val member = context.discordMessage.guild.getMember(user.handle) ?: run {
			context.sendMessage("Usuário não está na guild atual!")
			return@task true
		}

		NitroBoostUtils.onBoostActivate(member)

		context.reply(
				LorittaReply(
						"Vantagens de Booster Ativado!"
				)
		)
		return@task true
	}
}