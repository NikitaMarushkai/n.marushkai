package ru.kpfu.itis.group408.marushkai.ctv;

/**
 * Created by unlim_000 on 10.03.2015.
 */
public class VP implements ViewProvider<Student>{

    public int getColumnCount() {
        return 4;
    }


    public String getLabel(Student st, int n){
        String label = "";
        switch (n){
            case 1:
                label = st.getName();
                break;
            case 2:
                label = st.getGrade();
                break;
            case 3:
                label = st.getYear();
                break;
        }
        return label;
    }

    public String[] getHeader() {
        return new String[]{"Student", "Name", "Date", "Grade"};
    }


}
