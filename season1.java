public class season1 {
    public static void main(String[] args){

        season seasonLike = season.WINTER; //Переменная, содержащая мое любимое время года
        System.out.println("б) Мое любимое время года - " + seasonLike + ". Это " +
                seasonLike.getDescription() + " средняя темпиратура зимы: "
                + seasonLike.getAvgTemp()); //Вывод переменной и всей информации о ней

        likeSeas(season.AUTUMN);
        System.out.print("г,д) ");
        SeasonTemp();
        System.out.print("е) ");
        SeasonInf();
        System.out.print("ж) ");
        SeasonAll();
    }

    //Сщздаем метод для вывода любимого времени года, используем оператор swich
    public static void likeSeas(season season){
        switch (season) {
            case AUTUMN -> System.out.println("в) Я люблю осень.");
            case WINTER -> System.out.println("в) Я люблю зиму.");
            case SPRING -> System.out.println("в) Я люблю весну.");
            case SUMMER -> System.out.println("в) Я люблю лето.");
        }
    }

    //Цикл для вывода всех времен года и их средних темпиратур
    public static void SeasonTemp(){
        for (season i: season.values()) {
            System.out.println(i + " " + i.getAvgTemp());
        }
    }

    //Цикл для вывода всех времен года и их описания
    public static void SeasonInf(){
        for (season i: season.values()) {
            System.out.println(i + " " + i.getDescription());
        }
    }

    //Цикл для вывода всех времен года и всей информации о них
    public static void SeasonAll(){
        for (season i: season.values()) {
            System.out.println(i + ", средняя темпиратура " + i.getAvgTemp() + ". Это " + i.getDescription());
        }
    }

}
