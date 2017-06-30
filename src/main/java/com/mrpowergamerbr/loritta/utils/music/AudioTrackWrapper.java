package com.mrpowergamerbr.loritta.utils.music;

import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import net.dv8tion.jda.core.entities.User;

import java.util.HashMap;

@Getter
@Setter
@AllArgsConstructor
public class AudioTrackWrapper {
	public AudioTrack track;
	public boolean isAutoPlay;
	public User user;
	public HashMap<String, String> metadata = new HashMap<String, String>();
}
