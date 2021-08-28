package entities;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.util.vector.Vector3f;
 
public class Camera {
     
    private Vector3f position = new Vector3f(0,13,-110);
    private float pitch = 10;
    private float yaw ;
    private float roll;
    private float angle = 0;
     
    public Camera(){}
    
    public void invertPitch(){
        this.pitch = -pitch;
    }
     
    public void move(){
        if(Mouse.hasWheel()){
        	float zoomLevel = Mouse.getDWheel() * 0.03f;
        	float z = position.z;
        	z += zoomLevel;
        	if (z > -457.2005 && z <= -110 ){
        		
            position.z +=  zoomLevel;
            
        	}
            //System.out.println(z);
        }
        if(Mouse.isButtonDown(0)){
        	float old_yaw = this.yaw;
			float angleChange = Mouse.getDX() * 0.3f;
			angle -= angleChange;
			//if(angle < 43.19998 && angle > -55.799976){
				
			this.yaw = 10 - (position.y + angle);
			this.yaw%=360;
			//}
			/*if(yaw < 43.19998 && yaw  315.80023 )
			{
				this.yaw %= 90;
			}*/
			//System.out.println(angle);
			
		}
        if(Keyboard.isKeyDown(Keyboard.KEY_D)){
        	if(position.x < 250){
            position.x+=0.2f;
        	}
            //System.out.println(position.x);
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_A)){
        	if(position.x > -255){
            position.x-=0.2f;
        	}
            //System.out.println(position.x);
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_SPACE)){
        	//if(position.y < 22.20002){
            position.y+=0.2f;
        	//}
            System.out.println(position.x+" "+position.y+" "+position.z);
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)){
        	if(position.y > 13.199992){
            position.y-=0.2f;
        	}
            //System.out.println(position.y);
        }
    }
 
    public Vector3f getPosition() {
        return position;
    }
 
    public float getPitch() {
        return pitch;
    }
 
    public float getYaw() {
        return yaw;
    }
 
    public float getRoll() {
        return roll;
    }
     
     
 
}