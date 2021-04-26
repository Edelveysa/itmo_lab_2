package data;

public enum Mood {
    SORROW("sorrow", 1),
    GLOOM("gloom", 2),
    APATHY("apathy", 3),
    RAGE("rage", 0);

    private String mood;
    private int number;

    Mood(String mood, int number){
        this.number = number;
        this.mood = mood;
    }

    public String getMood() {
        return mood;
    }

    public int getNumber() {
        return number;
    }

    public static int findNumber(String s){
        int num = -1;
        if((s == "sorrow")||(s == "SORROW")){
            num = 1;
        }
        if((s == "gloom")||(s == "GLOOM")){
            num = 2;
        }
        if((s == "apathy")||(s == "APATHY")){
            num = 3;
        }
        if((s == "rage")||(s == "RAGE")){
            num = 0;
        }
        return num;
    }
}
