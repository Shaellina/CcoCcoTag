package video2audio;

import java.io.File;

import it.sauronsoftware.jave.AudioAttributes;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncodingAttributes;

public class VideoToAudio {
	public static void ConvertToAudio(File video, String realFileName, String codec, long id) {
		File Audio = new File("C:/dev/upload/"+id+"/"+realFileName+".wav");
		AudioAttributes audio = new AudioAttributes();
		audio.setCodec(codec);
		audio.setBitRate(new Integer(128000));

		audio.setChannels(new Integer(2));
		audio.setSamplingRate(new Integer(19200));
		EncodingAttributes attr = new EncodingAttributes();
		attr.setFormat("wav");
		attr.setAudioAttributes(audio);

		Encoder encode = new Encoder();
		try {
			encode.encode(video, Audio, attr);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
