package objects;


public enum movie_status{
        COMING_SOON("Coming soon"), 
        PREVIEW("Preview"),
        NOW_SHOWING("Now showing");

        private String status;
        movie_status(String status){
            this.status = status;
        }
}
