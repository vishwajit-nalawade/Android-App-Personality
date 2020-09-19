package com.example.personality;

import android.animation.Animator;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button option1,option2,option3,option4;
    private List<Question> questionList;
    int sum=0;
    int quesNum;
   TextView question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        option1 = findViewById(R.id.option1);
        option2 =  findViewById(R.id.option2);
        option3 =  findViewById(R.id.option3);
        option4 =  findViewById(R.id.option4);
        question = (TextView) findViewById(R.id.question);

        option1.setOnClickListener(this);
        option2.setOnClickListener(this);
        option3.setOnClickListener(this);
        option4.setOnClickListener(this);

        getQuestionsList();

        //Typeface typeface = ResourcesCompat.getFont(this,R.font.blacklist);
        //question.setTypeface(typeface);

    }

    private void getQuestionsList()
    {
        questionList = new ArrayList<>();
        questionList.add(new Question("What would you do if you were given a power to be invisible for one day?","Play tricks on others","Surprise your friends with gifts","Travel the world","Go to the tallest building's roof and feel it "));


        questionList.add(new Question("If you could be a Car , what would you be ?","Red Ferrari","Fiat 500","Mercedes benz - A Class","Nissan Frontier"));


        questionList.add(new Question("Which of these would you pick as a pet ?","Peacock","Swan","Panther","Sloth"));


        questionList.add(new Question("If you win a 100,000$ lottery, what would you do ?","A big Party, like never before","Buy gifts for friends and family","Shopping","Tour around the World"));

        questionList.add(new Question("Which movie genre do you like the most ?","Adventure and Action","Romantic , Comedy and Musical","Biopics of successful people","Psychological Thriller"));

        questionList.add(new Question("Which colour do you like the most ?","Scarlet","Baby Blue","Dark Green","Violet"));

        questionList.add(new Question("Which quality you appreciate most in other people","Optimism","Kindness","Determination","Tidiness"));

        questionList.add(new Question("Pick one word to describe yourself","Saviour","Sunshine","Gem","Wall Flower"));

        questionList.add(new Question("If you had a whole weekend to yourself , what would you do ?","Get Insanely Bored","Trip with group of friends","Half Time Party , Half Time Sleep","Wild Life Adventure"));

        questionList.add(new Question("Which season you like the most ?","Spring","Summer","Winter","Rainy"));

        setQuestion();
    }

    private void setQuestion()
    {
        question.setText(questionList.get(0).getQuestion());
        option1.setText(questionList.get(0).getOptionA());
        option2.setText(questionList.get(0).getOptionB());
        option3.setText(questionList.get(0).getOptionC());
        option4.setText(questionList.get(0).getOptionD());

        quesNum=0;

    }

    private void changeQuestion()
    {
        if(quesNum < questionList.size() - 1)
        {
            quesNum++;

            playAnim(question,0,0);
            playAnim(option1,0,1);
            playAnim(option2,0,2);
            playAnim(option3,0,3);
            playAnim(option4,0,4);
        }
        else
        {
            //Result Activity
            Intent intent = new Intent(MainActivity.this,LoadActivity.class);
            intent.putExtra("SUM", sum);
            startActivity(intent);
            MainActivity.this.finish();
        }
    }

    private void playAnim(final View view , final int value, final int viewNum)
    {
        view.animate().alpha(value).scaleX(value).scaleY(value).setDuration(500)
                .setStartDelay(100).setInterpolator(new DecelerateInterpolator())
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {


                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        if(value == 0)
                        {
                            switch (viewNum)
                            {
                                case 0:
                                    ((TextView)view).setText(questionList.get(quesNum).getQuestion());
                                    break;
                                case 1:
                                    ((Button)view).setText(questionList.get(quesNum).getOptionA());
                                    break;
                                case 2:
                                    ((Button)view).setText(questionList.get(quesNum).getOptionB());
                                    break;
                                case 3:
                                    ((Button)view).setText(questionList.get(quesNum).getOptionC());
                                    break;
                                case 4:
                                    ((Button)view).setText(questionList.get(quesNum).getOptionD());
                                    break;

                            }

                            playAnim(view,1,viewNum);
                        }

                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.option1:
                sum=sum+10;
                //playAnim(option1,0,1);
                changeQuestion();
                break;
            case R.id.option2:
                sum=sum+20;
                //playAnim(option2,0,2);
                changeQuestion();
                break;
            case R.id.option3:
                sum=sum+30;
                //playAnim(option3,0,3);
                changeQuestion();
                break;
            case R.id.option4:
                //playAnim(option4,0,4);
                sum=sum+40;
                changeQuestion();
                break;
        }
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }
}
