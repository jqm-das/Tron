import sun.audio.*; 
import java.io.*; 
public class Sound
{
   public static void main(String[] args)
   {
      music(); 
   }
   public static void music()
   {
      AudioPlayer mgp=AudioPlayer.player; 
      AudioStream bgm; 
      AudioData data; 
      
      ContinuousAudioDataStream loop=null; 
      try{
         bgm=new AudioStream(new FileInputStream("drums.WAV"));
         data=bgm.getData(); 
         loop=new ContinuousAudioDataStream(data); 
      }
      catch(IOException error)
      {
         mgp.start(loop); 
      }
   }
}