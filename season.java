public enum season { //Перечисление времен года, содержащих среднюю темпиратуру
    AUTUMN(9), WINTER(-10), SPRING(15),
    SUMMER(30){
        public String getDescription() { //Переопределение метода getDescription
            return "теплое время года.";
        }
    };

    public String getDescription() {
        return "холодное время года.";
    } //Метод getDescription

    //Конструктор, принимающий на вход среднюю темпиратуру
    final int avgTemp;
    season(int avgTemp){
        this.avgTemp = avgTemp;
    }
    public int getAvgTemp() {
        return avgTemp;
    }

}
