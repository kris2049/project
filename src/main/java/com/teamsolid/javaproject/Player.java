package com.teamsolid.javaproject;
import java.util.Random;

public class Player {
    private int[] position;
    private int distance;


    public Player() {
        this.position = new int[]{0, 0};
        this.distance = 0;
    }

    public int[] getPosition() {
        return position;
    }

    public void setPosition(int[] position) {
        this.position = position;
    }

    public void move(int steps) {
        distance += steps;

        if(distance>0 && distance<=8){
            this.position[0] = distance-1;
            this.position[1] = 0;
        }
        if(distance>8&&distance<=15){
            this.position[0] = 7;
            this.position[1] = distance-8;
        }
        if(distance>15&&distance<=22){
            this.position[0] = 7-(distance-15);
            this.position[1] = 7;
        }
        if(distance>22&&distance<=28){
            this.position[0] = 0;
            this.position[1] = 7-(distance-22);
        }


        if(distance>28&&distance<=34){
            this.position[0] = distance-28;
            this.position[1] = 1;
        }
        if(distance>34&&distance<=39){
            this.position[0] = 6;
            this.position[1] = distance-34+1;
        }
        if(distance>39&&distance<=44){
            this.position[0] = 6-(distance-39);
            this.position[1] = 6;
        }
        if(distance>44&&distance<=48){
            this.position[0] = 1;
            this.position[1] = 6-(distance-44);
        }


        if(distance>48&&distance<=52){
            this.position[0] = distance-48+1;
            this.position[1] = 2;
        }
        if(distance>52&&distance<=55){
            this.position[0] = 5;
            this.position[1] = distance-52+2;
        }
        if(distance>55&&distance<=58){
            this.position[0] = 5-(distance-55);
            this.position[1] = 5;
        }
        if(distance>58&&distance<=60){
            this.position[0] = 2;
            this.position[1] = 5-(distance-58);
        }


        if(distance>60&&distance<=62){
            this.position[0] = distance-60+2;
            this.position[1] = 3;
        }
        if(distance==63){
            this.position[0] = 4;
            this.position[1] = 4;
        }
        if(distance==64){
            this.position[0] = 3;
            this.position[1] = 4;
        }


    }

    public void move_valid(int[] position, int steps)
    {
        if(position[0]+steps > 8 && (position[1]+1)<8)
        {
            position[0] = steps-(8-position[0]);
            position[1] += 1;

        }

    }

    public void teleportToRandomLocation(){
        Random random = new Random();
        int randomX = random.nextInt(8); // 生成随机 X 坐标（0到7）
        int randomY = random.nextInt(8); // 生成随机 Y 坐标（0到7）
        this.position[0] = randomX;
        this.position[1] = randomY;
    }

    public void skipCurrentTurn(boolean skipTurn){
        if (skipTurn == true){
            return;
        }
    }

    public void teleportToBegin(){
        this.position[0] = 0;
        this.position[1] = 0;
    }
}