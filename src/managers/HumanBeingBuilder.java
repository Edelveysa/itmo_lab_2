package managers;

import data.*;
import exceptions.UndeclaredVariableException;

import java.util.Scanner;

public class HumanBeingBuilder {
    private Scanner scanner;

    HumanBeingBuilder(Scanner scanner){
        this.scanner = scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public String scanName() {
        String name;
        while (true){
            try{
                 System.out.println("Итак, имя вашего человека:");
                name = scanner.nextLine().trim();
                if (name.equals("")) throw new UndeclaredVariableException();
                break;
            } catch (UndeclaredVariableException e){
                System.out.println("У вашего человека должно быть имя!");
            }
        }
        return name;
    }

    public Coordinates scanCoordinates(){
        return new Coordinates(scanX(), scanY());
    }

    public Integer scanX(){
        String s;
        Integer x;
        while (true){
            try{
                System.out.println("Как насчет координаты Х? Обращу внимание, что максимальное значение Х - 841. \n Введите X:");
                s = scanner.nextLine().trim();
                x = Integer.valueOf(s);
                if (x.intValue() > 841) throw new UndeclaredVariableException();
                break;
            } catch (UndeclaredVariableException e){
                System.out.println("Максимальное значение - 841!");
            } catch (NumberFormatException e){
                System.out.println("Это было похоже на число?...");
            }
        }
        return x;
    }

    public Double scanY(){
        String s;
        Double y;
        while (true){
            try{
                System.out.println("Не забываем о второй координате.\n Введите Y:");
                s = scanner.nextLine().trim();
                y = Double.valueOf(s);
                break;
            } catch (NumberFormatException e){
                System.out.println("Это было похоже на число?...");
            }
        }
        return y;
    }

    public Boolean scanRealHero(){
        while(true)
            try{
                System.out.println("Ваш человек - герой?");
                String s = scanner.nextLine().trim();
                if(s.equals("Да") || s.equals("да") || s.equals("yes") || s.equals("Yes") || s.equals("+")){
                    return Boolean.TRUE;
                } if (s.equals("Нет") || s.equals("нет") || s.equals("no") || s.equals("No") || s.equals("-")){
                    return Boolean.FALSE;
                } else {
                    throw new UndeclaredVariableException();
                }
            } catch (UndeclaredVariableException e){
                System.out.println("Попробуем еще раз ответить на простой вопрос.");
            }


    }

    public Boolean scanHasToothPick(){
        while(true)
            try{
                System.out.println("Голливудская улыбка с соринками меж зубов - смотрится ужасно. \nУ вашего героя есть зубочистка?");
                String s = scanner.nextLine().trim();
                if(s.equals("Да") || s.equals("да") || s.equals("yes") || s.equals("Yes") || s.equals("+")){
                    return Boolean.TRUE;
                } if (s.equals("Нет") || s.equals("нет") || s.equals("no") || s.equals("No") || s.equals("-")){
                    return Boolean.FALSE;
                } else throw new UndeclaredVariableException();
            } catch (UndeclaredVariableException e){
                System.out.println("Неизвестно, хорошо.");
                return null;
            }

    }

    public long scanImpactSpeed(){
        String s;
        Long impactSpeed;
        while (true){
            try{
                System.out.println("Сила удара важна, когда закончились аргументы.\n Обращу внимание, что минимальное значение  - -621. \n Введите силу удара:");
                s = scanner.nextLine().trim();
                impactSpeed = Long.valueOf(s);
                if (impactSpeed.longValue()< -621) throw new UndeclaredVariableException();
                break;
            } catch (UndeclaredVariableException e){
                System.out.println("Минимальное значение - -621!");
            } catch (NumberFormatException e){
                System.out.println("Это было похоже на число?...");
            }
        }
        return impactSpeed.longValue();
    }

    public String scanSoundtrackName(){
        String soundName;
        while(true){
            try {
                System.out.println("Опенинг вашего человека должен отлично передавать роль и характер.\nВведите название саундтрека:");
                soundName = scanner.nextLine().trim();
                if(soundName.equals("")) throw new UndeclaredVariableException();
                break;
            } catch (UndeclaredVariableException e){
                System.out.println("Без саундрека - нет пути вперед.");
            }
        }
        return soundName;
    }

    public Integer scanMinutesOfWaiting(){
        String s;
        Integer minutes;
        while (true){
            try{
                System.out.println("Время ожидания...да, введите время ожидания вашего персонажа?");
                s = scanner.nextLine().trim();
                minutes = Integer.valueOf(s);
                break;
            } catch (NumberFormatException e){
                System.out.println("Это было похоже на число?...Ну ладно, нет, так нет.");
                return null;
            }
        }
        return minutes;

    }

    public Mood scanMood(){
        String s;
        while(true){
            try {
                System.out.println("Как настроение? Могу предложить: \nГоре\nМрак\nАпатия\nГнев. \nВаш выбор:");
                s = scanner.nextLine().trim();
                if(s.equals("Горе")||s.equals("горе")){
                    return Mood.SORROW;
                }if(s.equals("Мрак")||s.equals("мрак")){
                    return Mood.GLOOM;
                } if (s.equals("Апатия")||s.equals("апатия")){
                    return Mood.APATHY;
                } if (s.equals("Гнев")||s.equals("гнев")){
                    return Mood.RAGE;
                }else throw new UndeclaredVariableException();
            }catch(UndeclaredVariableException e){
                System.out.println("Все ясно, настроение отсутствует.");
                return null;
            }
        }
    }

    public Car scanCar(){
        String name;
        Boolean cool;
        System.out.println("Пора поговорить о машине!");
        return new Car(scanCarName(), scanCarIsCool());
    }

    public String scanCarName(){
        String s;
        while(true){
            try {
                System.out.println("Имя машины? Ну или марка, как хотите, только введите:");
                s = scanner.nextLine().trim();
                if(s.equals("")) throw new UndeclaredVariableException();
                break;
            } catch (UndeclaredVariableException e){
                System.out.println("У машины должно быть имя! Или марка.");
            }
        }
        return s;
    }

    public Boolean scanCarIsCool(){
        String s;
        while (true){
            try {
                System.out.println("Это крутая машина?");
                s = scanner.nextLine().trim();
                if(s.equals("Да") || s.equals("да") || s.equals("yes") || s.equals("Yes") || s.equals("+")){
                    return Boolean.TRUE;
                } if (s.equals("Нет") || s.equals("нет") || s.equals("no") || s.equals("No") || s.equals("-")){
                    return Boolean.FALSE;
                } else {
                    throw new UndeclaredVariableException();
                }
            } catch (UndeclaredVariableException e){
                System.out.println("Попробуем еще раз ответить на простой вопрос.");
            }
        }

    }


}
