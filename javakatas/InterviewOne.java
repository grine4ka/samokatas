package ru.bykov.javakatas;

/**
 * Created by g.bykov on 02/02/2017.
 */
public class InterviewOne {

    public static void main(String[] args) {
        checkKey();

//        Long a = 111L;
//        Long b = 111L;
//        Long c = 222L;
//        Long d = 222L;
//
//        System.out.println(a == b);
//        System.out.println(c == d);
//        List<String> arrayList = new ArrayList<>();
//        List<String> emptyList = Collections.emptyList();
//        System.out.println("Class of array list is " + arrayList.getClass());
//        System.out.println("Class of empty list is " + emptyList.getClass());
//        System.out.println("Class equality " + (emptyList.getClass() == Collections.emptyList().getClass()));
//        System.out.println("Reference equality " + (emptyList == Collections.<String>emptyList()));

//        List<Integer> dates = new ArrayList<>();
//        dates.add(1000);
//        dates.add(2000);
//        dates.add(30000);
//        dates.add(40932);
//        dates.add(341212);
//        dates.add(1235125);
//        dates.sort(Comparator.reverseOrder());
//
//        System.out.println(dates);
    }

    interface Thing {

        void doIt();
    }

    abstract class Car implements Thing {

    }

    public static void checkKey() {
        final String string = "62956f9b20a7220926dac5c6bbbbb51a";
        final int length = string.length();
        final String a = a(string.substring(0, length / 2).getBytes(), string.substring(length / 2, length).getBytes());
        final StringBuilder sb = new StringBuilder("R");
        sb.append("V");
        sb.append(a.substring(0, length / 4));
        sb.append("N");
        sb.reverse();
        sb.append("2");
        System.out.println(sb.toString());
    }

    public static String a(byte[] paramArrayOfByte)
    {
        StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 2);
        int j = paramArrayOfByte.length;
        int i = 0;
        while (i < j)
        {
            localStringBuilder.append(String.format("%02x", new Object[] { Byte.valueOf(paramArrayOfByte[i]) }));
            i += 1;
        }
        return localStringBuilder.toString();
    }

    private static String a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    {
        byte[] arrayOfByte = new byte[paramArrayOfByte1.length];
        int i = 0;
        while (i < paramArrayOfByte1.length)
        {
            arrayOfByte[i] = ((byte)(paramArrayOfByte1[i] ^ paramArrayOfByte2[(i % paramArrayOfByte2.length)]));
            i += 1;
        }
        return a(arrayOfByte);
    }
}
