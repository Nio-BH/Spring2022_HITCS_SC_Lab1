package P3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FriendshipGraph {
	private List<Person> Partner;
	
	public FriendshipGraph() {
		this.Partner=new ArrayList<>();
	}
	
	public List<Person> partner() {
		return Partner;
	}
	public int addVertex(Person name) {
		int n=Partner.size();
		for(int i=0;i<n;i++) {
			if(Partner.get(i).name()==name.name()) {
				System.out.println("Already have this person!");
				return i;
			}
		}
		Partner.add(name);
		return Partner.indexOf(name);
	}
	public void addEdge(Person A,Person B) {
		if(Partner.contains(A)&&Partner.contains(B)) {
			if(A==B)return;
			if(A.frind().contains(B)) {
				return;
			}
			else {
		A.AddFrind(B);//给A的frind添加B
		}}
		else return;
	}
	public int getDistance(Person A,Person B) {//计算A到B的最短路径
		if(Partner.contains(A)&&Partner.contains(B)) {
			if(A==B)return 0;
			Queue<Person> Queue=new LinkedList<>();
			int flag[]=new int[Partner.size()];
			int n=0,i=0,nowIndex;
			Person now=null;
			flag[Partner.indexOf(A)]=1;
			Queue.add(A);
			now=Queue.poll();
			while(now!=null) {
				n=now.frind().size();//n是now的朋友数
				nowIndex=Partner.indexOf(now);//nowIndex是now在Partner中对应下标
				for(i=0;i<n;i++) {
					if(now.frind().get(i)==B) {
						return flag[nowIndex];
					}
					else {
					if(flag[Partner.indexOf(now.frind().get(i))]==0){
					flag[Partner.indexOf(now.frind().get(i))]=flag[nowIndex]+1;
					Queue.add(now.frind().get(i));
																	}
						 }
								}
				now=Queue.poll();
			}
			return -1;
		}
		else {
			return -1;
		}
	}
}
