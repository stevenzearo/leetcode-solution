package test2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author Steve Zou
 */
public class Demo {

    public List<String> splitStr(String s, int n) {
        List<String> allWords = Arrays.asList(s.split("\\s+")).stream().filter(str -> !s.trim().isEmpty()).collect(Collectors.toList());

        List<String> cleanWords = new ArrayList<>();

        for (String word : allWords) {
            List<String> subWords = Arrays.asList(word.trim().split(","));
            for (int i = 0; i < subWords.size(); i++) {
                if (subWords.get(i).isEmpty()) continue;
                if (i != subWords.size() - 1) {
                    String a = subWords.get(i);
                    a += ",";
                    subWords.set(i, a);
                }
                cleanWords.add(subWords.get(i));
            }
        }

        if (cleanWords.size() <= 1) return cleanWords;

        StringBuilder line = new StringBuilder(cleanWords.get(0));
        List<String> result = new ArrayList<>();
        for (int i = 1; i < cleanWords.size(); i++) {
            String str = cleanWords.get(i);
            line.append(" ");
            line.append(str);
            if (line.length() >= n) {
                result.add(line.toString().trim());
                line = new StringBuilder();
            } else if (line.length() == n - 1) {
                result.add(line.toString().trim());
                line = new StringBuilder();
            }
            if (i == cleanWords.size() - 1) {
                result.add(line.toString().trim());
            }
        }
        return result;
    }

    // Str = "The quick,brown    fox  jumps over the lazy dog"
// N = 10
// Expects: [
// "The quick,",
// "brown fox",
// "jumps over",
// "the lazy",
// "dog"]
    public static void main(String[] args) throws InterruptedException {
//        Demo demo = new Demo();
//        List<String> strings = demo.splitStr("The quick,brown    fox  jumps over the lazy dog", 10);
//        strings.forEach(System.out::println);
        SynchronousQueue<Runnable> synchronousQueue = new SynchronousQueue<>();
        synchronousQueue.offer(() -> {
            System.out.println("hello");
        });

        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 20, 2, TimeUnit.SECONDS, synchronousQueue);
        executor.submit(() -> {
            System.out.println("are you ok?");
        });
    }
}
