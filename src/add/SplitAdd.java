package add;

class SplitAdd {
    public static void splitText(String text) {
        String[] words = text.split("\\s+");
        for (String word : words) {
            System.out.println(word);
        }
    }
}