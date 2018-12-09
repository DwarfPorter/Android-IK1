package ru.geekbrains.socialnetwork;

public class SocChangableSource implements SocialChangableSource {

    private int count;
    private SocialDataSource dataSource;

    public SocChangableSource(SocialDataSource dataSource) {
        this.dataSource = dataSource;
        count = 0;
    }

    @Override
    public void add() {
        if (count < dataSource.length()){
            count ++;
        }
    }

    @Override
    public void delete() {
        if (count > 0){
            count--;
        }
    }

    @Override
    public Soc getSoc(int position) {
        return dataSource.getSoc(position);
    }

    @Override
    public int length() {
        return count;
    }
}
