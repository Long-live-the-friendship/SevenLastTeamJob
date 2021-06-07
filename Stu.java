public class Stu {
    Integer id;  //教师的id

    int time; //教师名字


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public Stu() {
    }

    @Override
    public String toString() {
        return "Stu{" +
                "id=" + id +
                ", time='" + time + '\'' +
                '}';
    }

    public Stu(Integer id, int time) {
        this.id = id;
        this.time = time;
    }
}
