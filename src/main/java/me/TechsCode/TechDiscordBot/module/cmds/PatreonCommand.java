package me.TechsCode.TechDiscordBot.module.cmds;

import me.TechsCode.TechDiscordBot.TechDiscordBot;
import me.TechsCode.TechDiscordBot.module.CommandModule;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.interactions.InteractionHook;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.api.interactions.commands.privileges.CommandPrivilege;

public class PatreonCommand extends CommandModule {

    public PatreonCommand(TechDiscordBot bot) {
        super(bot);
    }

    @Override
    public String getName() {
        return "patreon";
    }

    @Override
    public String getDescription() {
        return "Returns the patreon website!";
    }

    @Override
    public CommandPrivilege[] getCommandPrivileges() {
        return new CommandPrivilege[0];
    }

    @Override
    public OptionData[] getOptions() {
        return new OptionData[0];
    }

    @Override
    public int getCooldown() {
        return 5;
    }

    @Override
    public void onCommand(TextChannel channel, Member m, InteractionHook hook, SlashCommandEvent e) {
        boolean isPatron = m.getRoles().stream().anyMatch(r -> r.getName().equals("Patreon"));

        e.reply((isPatron ? "Thank you for being a Patron!\n\n" : "") + "https://patreon.com/TechsCode").queue();
    }
}
