package tests;

public class Keyboard {
	private boolean vK_W =false;
	private boolean vK_A =false;
	private boolean vK_S =false;
	private boolean vK_D =false;
	private boolean vK_R =false;
	private boolean vK_Space =false;
	private boolean vK_1 =false;
	private boolean vK_2 =false;
	private boolean bT_1 =false;
	private boolean bT_2 =false;
	private boolean bT_3 =false;

	public boolean isPressed(String key){
		switch (key){
		
		case "vK_W":
			return vK_W;
		case "vK_A":
			return vK_A;
		case "vK_S":
			return vK_S;
		case "vK_D":
			return vK_D;
		case "vK_R":
			return vK_R;
		case "vK_Space":
			return vK_Space;
		case "vK_1":
			return vK_1;
		case "vK_2":
			return vK_2;
		case "bT_1":
			return bT_1;
		case "bT_2":
			return bT_2;
		case "bT_3":
			return bT_3;
		default:
			return false;
		
		}
		
	}
	
	public void setVK_W(boolean b){
		this.vK_W=b;
	}
	public void setVK_A(boolean b){
		this.vK_A=b;
	}
	public void setVK_S(boolean b){
		this.vK_S=b;
	}
	public void setVK_D(boolean b){
		this.vK_D=b;
	}
	public void setVK_Space(boolean b){
		this.vK_Space=b;
	}
	public void setVK_R(boolean b){
		this.vK_R=b;
	}
	public void setVK_1(boolean vK_1) {
		this.vK_1 = vK_1;
	}
	public void setVK_2(boolean vK_2) {
		this.vK_2 = vK_2;
	}
	public void setbT_1(boolean bT_1) {
		this.bT_1 = bT_1;
	}
	public void setbT_2(boolean bT_2) {
		this.bT_2 = bT_2;
	}
	public void setbT_3(boolean bT_3) {
		this.bT_3 = bT_3;
	}
	
	
}
