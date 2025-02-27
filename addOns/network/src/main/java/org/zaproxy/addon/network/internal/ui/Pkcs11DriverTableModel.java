/*
 * Zed Attack Proxy (ZAP) and its related class files.
 *
 * ZAP is an HTTP/HTTPS proxy for assessing web application security.
 *
 * Copyright 2022 The ZAP Development Team
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.zaproxy.addon.network.internal.ui;

import java.util.List;
import org.parosproxy.paros.Constant;
import org.zaproxy.addon.network.internal.client.Pkcs11Driver;
import org.zaproxy.addon.network.internal.client.Pkcs11Drivers;
import org.zaproxy.zap.view.AbstractMultipleOptionsBaseTableModel;

public class Pkcs11DriverTableModel extends AbstractMultipleOptionsBaseTableModel<Pkcs11Driver> {

    private static final long serialVersionUID = 1L;

    private static final String[] COLUMN_NAMES = {
        Constant.messages.getString("network.ui.options.pkcs11driver.table.header.name"),
        Constant.messages.getString("network.ui.options.pkcs11driver.table.header.slot"),
        Constant.messages.getString("network.ui.options.pkcs11driver.table.header.slotlistindex")
    };

    private static final int COLUMN_COUNT = COLUMN_NAMES.length;

    private final Pkcs11Drivers drivers;

    public Pkcs11DriverTableModel(Pkcs11Drivers drivers) {
        this.drivers = drivers;
    }

    @Override
    public String getColumnName(int col) {
        return COLUMN_NAMES[col];
    }

    @Override
    public int getColumnCount() {
        return COLUMN_COUNT;
    }

    @Override
    public int getRowCount() {
        return drivers.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return getElement(rowIndex).getName();
            case 1:
                return getElement(rowIndex).getSlot();
            case 2:
                return getElement(rowIndex).getSlotListIndex();
            default:
                return "";
        }
    }

    @Override
    public Class<?> getColumnClass(int c) {
        return String.class;
    }

    @Override
    public List<Pkcs11Driver> getElements() {
        return drivers;
    }
}
