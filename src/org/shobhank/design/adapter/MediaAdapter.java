package design.adapter;
/**
 *
 * @author shsharma
 */
public class MediaAdapter implements MediaPlayer{

	AdvancedMediaPlayer advancedMediaPlayer;
	
	MediaAdapter(String audioType){
		if(audioType.equalsIgnoreCase("vlc"))
			advancedMediaPlayer = new VLCPlayer();
		else if(audioType.equalsIgnoreCase("mp4"))
			advancedMediaPlayer = new Mp4Player();
		else 
			advancedMediaPlayer = null;
	}
	
	@Override
	public void play(String audioType, String fileName) {
		// TODO Auto-generated method stub
		if(audioType.equalsIgnoreCase("vlc"))
			advancedMediaPlayer.playVlc(fileName);
		else if(audioType.equalsIgnoreCase("mp4"))
			advancedMediaPlayer.playMp4(fileName);
	}

}
