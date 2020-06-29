/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalfinance.gui.panel;

import javax.swing.JPanel;
import personalfinance.gui.Chart;
import personalfinance.gui.MainFrame;
import personalfinance.model.Statistics;
import personalfinance.saveload.SaveData;
import personalfinance.settings.Style;

/**
 *
 * @author Admin
 */
public class StatisticsPanel extends RightPanel {
    
    public static final int TYPE_INCOME = 0;
    public static final int TYPE_EXP = 1;
    private int type = TYPE_INCOME;

    public StatisticsPanel(MainFrame frame) {
        super(frame, null, "STATISTICS", Style.ICON_PANEL_STATISTICS,
            new JPanel[]{
                new FilterPanel(frame),
                new StatisticsTypePanel(frame, "CHART_INCOME"),
                new Chart(Statistics.getDataForChartOnIncomeArticles(), "CHART_INCOME", SaveData.getInstance().getBaseCurrency().getCode()).getPanel()
            });
    }
    
    public void nextType() {
        type++;
        if (type > TYPE_EXP) type = TYPE_INCOME;
    }
    
    @Override
    public void refresh() {
        Chart chart = null;
        String title = null;
        if (type == TYPE_INCOME) {
            title = "CHART_INCOME";
            chart =  new Chart(Statistics.getDataForChartOnIncomeArticles(), title, SaveData.getInstance().getBaseCurrency().getCode());
        }
        else if (type == TYPE_EXP) {
            title = "CHART_EXP";
            chart =  new Chart(Statistics.getDataForChartOnExpArticles(), title, SaveData.getInstance().getBaseCurrency().getCode());
        }
        setPanels(new JPanel[]{
                new FilterPanel(frame),
                new StatisticsTypePanel(frame, title),
                chart.getPanel()
            });
        super.refresh();
    }
    
}
