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

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.parosproxy.paros.Constant;

public class CertificatesTableModel extends AbstractTableModel {

    private static final long serialVersionUID = 1L;

    private static final String[] COLUMN_NAMES = {
        Constant.messages.getString(
                "network.ui.options.clientcertificates.keystore.certs.table.header")
    };

    private static final int COLUMN_COUNT = COLUMN_NAMES.length;

    private final List<String> certificates;

    public CertificatesTableModel() {
        certificates = new ArrayList<>();
    }

    public void addCertificate(String certificate) {
        certificates.add(certificate);
        int index = certificates.size() - 1;
        fireTableRowsInserted(index, index);
    }

    public void clear() {
        certificates.clear();
        fireTableDataChanged();
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
    public Class<?> getColumnClass(int c) {
        return String.class;
    }

    @Override
    public int getRowCount() {
        return certificates.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return certificates.get(rowIndex);
    }
}
