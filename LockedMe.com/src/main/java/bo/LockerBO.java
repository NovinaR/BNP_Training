package bo;

import java.util.List;

import model.Locker;

public interface LockerBO {
	
	public List<String> getallfiles();
	public Locker createfile(Locker locker);
	public Locker deletefile(int key);
	public Locker searchfile(String filename);
	public Locker demo(Locker locker);

}