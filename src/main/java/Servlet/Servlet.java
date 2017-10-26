package Servlet;

import Game.Game;
import Serialization.Serialization;
import model.Factory;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;


public class Servlet extends HttpServlet {
    private Game game;
    private int[] secretNumber;
    private Factory factory;
    private Serialization serialization;

    public Servlet() {
        game = new Game();
        secretNumber = new int[4];
        secretNumber = game.makeSecretNumber();
        factory = new Factory();
        serialization = new Serialization();
    }

    ArrayList<String> arrayList = new ArrayList<String>();
    ArrayList<String> arrayListInteger = new ArrayList<String>();
    ArrayList<User> userNameList = new ArrayList<User>();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        factory = serialization.read();
        login(req, resp);
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    public void process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        res.setContentType("text/html;charset=UTF-8");

        HttpSession session = req.getSession();
        Integer userNumber;
        String parameter = req.getParameter("userNumber");
        arrayList.add(parameter);
        userNumber = Integer.parseInt(parameter);
        int bulls = game.checkBulls(userNumber);
        int cows = game.checkCows(userNumber);
        String s2 = "Быки: " + bulls + " Коровы: " + cows;
        arrayListInteger.add(s2);


        session.setAttribute("number", userNumber);
        session.setAttribute("string", s2);

        session.setAttribute("listCowsAndBulls", arrayListInteger);
        session.setAttribute("listNumber", arrayList);
        if (bulls == 4) {
            session.setAttribute("win", "Вы выиграли");
            serialization.save();
        }
        cows = 0;
        bulls = 0;
        game.setNumberBulls(0);
        game.setNumberBulls(0);
        req.getRequestDispatcher("game.jsp").forward(req, res);

    }

    public void login(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html;charset=UTF-8");
        HttpSession session = req.getSession();
        String userName = req.getParameter("user");

        for (User user : userNameList) {
            if (user.getName() != userName) {
                userNameList.add(new User(userName));
            }
            session.setAttribute("topUser", factory.getUserArrayList());
            req.getRequestDispatcher("index.jsp").forward(req, res);

        }


    }


}
