package design.adapter;
/**
 *
 * @author shsharma
 */
public class AudioPlayer implements MediaPlayer{

	MediaAdapter mediaAdapter;
	
	@Override
	public void play(String audioType, String fileName) {
		// TODO Auto-generated method stub
		if(audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")){
			mediaAdapter = new MediaAdapter(audioType);
			mediaAdapter.play(audioType, fileName);
		}else if(audioType.equalsIgnoreCase("mp3")){
			System.out.println("Playing mp3 " + fileName);
		}else{
			System.out.println("Invalid format");
		}
			
	}

}
