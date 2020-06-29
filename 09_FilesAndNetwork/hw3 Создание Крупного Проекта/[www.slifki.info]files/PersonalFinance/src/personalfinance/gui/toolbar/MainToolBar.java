/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalfinance.gui.toolbar;

import personalfinance.gui.handler.MainToolBarHandler;
import personalfinance.settings.HandlerCode;
import personalfinance.settings.Style;
import personalfinance.settings.Text;

/**
 *
 * @author Admin
 */
public final class MainToolBar extends AbstractToolBar {
    
    public MainToolBar(MainToolBarHandler handler) {
        super(Style.BORDER_MAIN_TOOLBAR, handler);
        init();
    }

    @Override
    protected void init() {
        addButton(Text.get("TOOLBAR_OVERVIEW"), Style.ICON_TOOLBAR_OVERVIEW, HandlerCode.TOOLBAR_OVERVIEW, true);
        addButton(Text.get("TOOLBAR_ACCOUNTS"), Style.ICON_TOOLBAR_ACCOUNTS, HandlerCode.TOOLBAR_ACCOUNTS, true);
        addButton(Text.get("TOOLBAR_ARTICLES"), Style.ICON_TOOLBAR_ARTICLES, HandlerCode.TOOLBAR_ARTICLES, true);
        addButton(Text.get("TOOLBAR_TRANSACTIONS"), Style.ICON_TOOLBAR_TRANSACTIONS, HandlerCode.TOOLBAR_TRANSACTIONS, true);
        addButton(Text.get("TOOLBAR_TRANSFERS"), Style.ICON_TOOLBAR_TRANSFERS, HandlerCode.TOOLBAR_TRANSFERS, true);
        addButton(Text.get("TOOLBAR_CURRENCIES"), Style.ICON_TOOLBAR_CURRENCIES, HandlerCode.TOOLBAR_CURRENCIES, true);
        addButton(Text.get("TOOLBAR_STATISTICS"), Style.ICON_TOOLBAR_STATISTICS, HandlerCode.TOOLBAR_STATISTICS, true);
    }
    
}
