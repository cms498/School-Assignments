package mcf;

public class ForEach {
    public static void forArray(String[] array){
        for(String element : array){
            System.out.println(element);
        }
    }

    public static void forList(List<String> list){
        for(String element : list){
            System.out.println(element);
        }
    }
    public static void main(String[] args) {
        String[] array = {"abc", "def", "ghi\n"};
        forArray(array);

        List<String> LinkedList = new LinkedList<>();
        LinkedList.append("abc");
        LinkedList.append("def");
        LinkedList.append("ghi\n");
        forList(LinkedList);

        List<String> ArrayList = new ArrayList<>();
        ArrayList.append("abc");
        ArrayList.append("def");
        ArrayList.append("ghi\n");
        forList(ArrayList);
    }
}