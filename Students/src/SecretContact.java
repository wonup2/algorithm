import java.io.*;

public class SecretContact {
    public static void main(String[] args) throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int blah = Integer.parseInt(in.readLine());
        for(int i =1; i<= blah; i++) 
        {
            String line1 = in.readLine();
            String[] bruh = line1.split("\\|");
            char[] prompt = bruh[0].toCharArray();
            char[] response = bruh[1].toCharArray();

            int infractions = 0;
            for(int n = 0; n<response.length; n++) 
            {
                //System.out.println(response[n]);
                int lol = 0;
                char g = response[n];
                for(int j = 0; j<prompt.length; j++) 
                {

                    if(Character.toLowerCase(prompt[j])== Character.toLowerCase(g)) 
                    {
                        //System.out.println(prompt[j]);
                        lol++;
                    }
                }
                if(lol == 0) 
                {
                    infractions++;
                }

            }
            if(infractions == 0)System.out.println("That's my secret contact!");
            if(infractions != 0)System.out.println("You're not a secret agent!");

        }
        in.close();
    }
}