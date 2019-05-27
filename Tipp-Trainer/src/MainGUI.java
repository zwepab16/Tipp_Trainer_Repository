
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Zwetti Patrick
 */
public class MainGUI extends javax.swing.JFrame implements KeyListener {

    /**
     * Variable are here
     */
    private DataBase db;
    private PlayBl model = new PlayBl();
    private Boolean gameRunning = false;
    private int time = 0;
    private int anz = 0;
    private String currentUser;

    /**
     * Creates new form MainGUI
     */
    public MainGUI() {
        initComponents();
        this.setTitle("Tipp-Trainer");
        /**
         * DataBase get added and created!
         */
        try {
            db = DataBase.getInstance();
            db.createTableUsers();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        /**
         * List model get loaded!
         */
        liPlayList.setModel(model);
        liPlayList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        /**
         * Login Dialog gets showed!
         */
        loginSigin();
        btEnterGame.addKeyListener(this);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        paBackground = new javax.swing.JPanel();
        lbWho = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        liPlayList = new javax.swing.JList<>();
        btEnterGame = new javax.swing.JButton();
        lbTime = new javax.swing.JLabel();
        lbKey = new javax.swing.JLabel();
        lbStatus = new javax.swing.JLabel();
        tfText = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        miLogOut = new javax.swing.JMenuItem();
        miRanking = new javax.swing.JMenuItem();
        miClose = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        lbWho.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Select Level")));

        liPlayList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        liPlayList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                liPlayListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(liPlayList);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
        );

        btEnterGame.setText("Start Game");
        btEnterGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEnterGameActionPerformed(evt);
            }
        });

        lbTime.setBorder(javax.swing.BorderFactory.createTitledBorder("Needed Time"));

        lbKey.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 48)); // NOI18N
        lbKey.setBorder(javax.swing.BorderFactory.createTitledBorder("Needed Key"));

        lbStatus.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbStatus.setBorder(javax.swing.BorderFactory.createTitledBorder("GameStatus"));

        tfText.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        tfText.setBorder(javax.swing.BorderFactory.createTitledBorder("Text"));
        tfText.setOpaque(true);

        javax.swing.GroupLayout paBackgroundLayout = new javax.swing.GroupLayout(paBackground);
        paBackground.setLayout(paBackgroundLayout);
        paBackgroundLayout.setHorizontalGroup(
            paBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paBackgroundLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(paBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(paBackgroundLayout.createSequentialGroup()
                        .addComponent(lbKey, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(paBackgroundLayout.createSequentialGroup()
                        .addComponent(btEnterGame, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 330, Short.MAX_VALUE)
                        .addComponent(lbWho, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(paBackgroundLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lbTime, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tfText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        paBackgroundLayout.setVerticalGroup(
            paBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paBackgroundLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(paBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(paBackgroundLayout.createSequentialGroup()
                        .addGroup(paBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbWho, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(paBackgroundLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(btEnterGame, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(33, 33, 33)
                        .addComponent(lbStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(lbTime, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tfText, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(lbKey, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jMenu1.setText("Settings");

        miLogOut.setText("Log out");
        miLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miLogOutActionPerformed(evt);
            }
        });
        jMenu1.add(miLogOut);

        miRanking.setText("Show ranking");
        miRanking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miRankingActionPerformed(evt);
            }
        });
        jMenu1.add(miRanking);

        miClose.setText("Close");
        miClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCloseActionPerformed(evt);
            }
        });
        jMenu1.add(miClose);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(paBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(paBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btEnterGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEnterGameActionPerformed
        /**
         * Looks for Selected Level and loads it Waits for User input to start
         * Starts timer
         */

        try {
            if (liPlayList.isSelectionEmpty()) {
                JOptionPane.showMessageDialog(null, "Please select first a Level!");
            } else {
                time = 0;
                String txt = model.enterGame(liPlayList.getSelectedIndex());
                tfText.setText(txt);
                lbStatus.setText("Game starts with first pressed key!");
                lbKey.setText(tfText.getText().charAt(0) + "");
            }
        } catch (IOException ex) {
            Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btEnterGameActionPerformed

    private void miLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miLogOutActionPerformed
        /**
         * current user gets log out Label Text gets changed Login Dialog gets
         * showed!
         */

        currentUser = "";
        lbWho.setText("");
        gameEnd();
        loginSigin();
    }//GEN-LAST:event_miLogOutActionPerformed

    private void liPlayListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_liPlayListValueChanged
        /**
         * If User select an other level it gets changed!
         */
        lbStatus.setText("Game selected!");
    }//GEN-LAST:event_liPlayListValueChanged

    private void miCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCloseActionPerformed
        /**
         * Game stops Window gets closed.
         */

        gameEnd();
        System.exit(EXIT_ON_CLOSE);
    }//GEN-LAST:event_miCloseActionPerformed

    private void miRankingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miRankingActionPerformed
        /**
         * For Future update
         */
    }//GEN-LAST:event_miRankingActionPerformed

    private void loginSigin() {
        
        /**
         * Login Dialog gets showed!
         */

        LoginDialog d = new LoginDialog(new JFrame(), true);
        d.setVisible(true);
        try {
            /**
             * If Button =1
             * Input gets checked
             * True-> User gets loged in
             * False-> JOption Pane + Login Dialog gets showed again
             */
            if (d.getButton() == 1) {
                User s = d.getUser();

                Boolean b = db.checkLogin(s);

                if (b) {
                    lbWho.setText("Logged in as: " + s.getUsername());
                    currentUser = s.getUsername();

                } else {

                    JOptionPane.showMessageDialog(null, "Username or Password incorrect!");
                    loginSigin();
                }
                
                /**
             * If Button =2
             * Input gets checked if it is douple
             * False-> User gets loged in
             * True-> JOption Pane + Login Dialog gets showed again
             */
                
            } else if (d.getButton() == 2) {
                User s = d.getUser();
                db.insertTestData(s.getUsername(), s.getPassword(), 0);
            }

        } catch (org.postgresql.util.PSQLException ex) {

            JOptionPane.showMessageDialog(null, "Username is already used!");
            loginSigin();
        } catch (Exception ex) {
            Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Fehler");
            loginSigin();
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */

 /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btEnterGame;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbKey;
    private javax.swing.JLabel lbStatus;
    private javax.swing.JLabel lbTime;
    private javax.swing.JLabel lbWho;
    private javax.swing.JList<String> liPlayList;
    private javax.swing.JMenuItem miClose;
    private javax.swing.JMenuItem miLogOut;
    private javax.swing.JMenuItem miRanking;
    private javax.swing.JPanel paBackground;
    private javax.swing.JLabel tfText;
    // End of variables declaration//GEN-END:variables

    @Override
    public void keyTyped(KeyEvent ke) {
        /**
         * If Player type a key and game is running-> Game starts
         * 
         */
        btEnterGame.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "none");

        gameRunning = true;
        lbStatus.setText("Game is runnig");
        if (anz == 0) {
            anz++;
            
            /**
             * Thread counts seconds that a player need to finish game!
             */
            
            new Thread(new Runnable() {
                @Override
                public void run() {

                    while (gameRunning) {
                        try {

                            lbTime.setText(++time + " Seconds");
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                }
            }).start();
        }

        if (gameRunning) {
            
            /**
             * Needed key gets showed in a label
             * If player types the right key 
             * True-> label becomes green and User can type the next key
             * False-> label becomes red and User has to click the right key!
             */

            if (ke.getKeyChar() == tfText.getText().charAt(0)) {
                lbKey.setForeground(Color.green);
                tfText.setText(tfText.getText().substring(1));
                try {
                    lbKey.setText(tfText.getText().charAt(0) + "");
                } catch (Exception e) {
                }
                
                /**
                 * If the Text Field is empty -> Methode "gameEnd()" gets called!
                 */
                if (tfText.getText().isEmpty()) {

                    gameEnd();

                }
            } else {
                lbKey.setForeground(Color.red);
            }
        }

    }

    public void gameEnd() {

        /**
         * IF Game is finished Labels gets resetet And "Finished Message" get
         * showed!
         */
        gameRunning = false;
        JOptionPane.showMessageDialog(null, "You needed for " + model.getNowText().length() + " Characters " + time + " Seconds");
        anz = 0;
        tfText.setText("");
        lbTime.setText("");
        lbStatus.setText("Game finished!");
        lbKey.setText("");
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        /**
         * Not needed yet
         */
    }

    @Override
    public void keyReleased(KeyEvent ke) {
         /**
         * Not needed yet
         */

    }
}
