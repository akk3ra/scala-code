import AnonyIntf.java;
class AnonyFunc {
	static AnonyIntf func = new AnonyIntf(){
		@Override
		public Boolean func(int i){
			if(i>10) return true;
			else return false;	
		}
	};
	public static void main(String[] args){	
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(5);
		list.add(6);
		list.add(9);
		int val = findMatch(list, func, 3);
		System.out.println(val);
	}
	public static <T> T findMatch(List<T> list, AnonyIntf func, T i){
		for(T t: list) {
			if(func.func(t)) return t;
		}
	return i;
	}
}


