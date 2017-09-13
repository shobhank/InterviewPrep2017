package design.adapter;
/**
 *
 * @author shsharma
 */
public class Demo {
	public static void main(String asp[]){
		MediaPlayer mp = new AudioPlayer();
		mp.play("mp3", "abc.mp3");
		mp.play("vlc", "abc.avi");
		mp.play("mp4", "abc.mp4");
		mp.play("xlr", "abc.xlr");
	}
}
