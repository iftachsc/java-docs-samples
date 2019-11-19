/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.bigtable;

import static com.google.cloud.bigtable.data.v2.models.Filters.FILTERS;
// [START bigtable_filters_limit_row_sample]
// [START bigtable_filters_limit_row_regex]
// [START bigtable_filters_limit_cells_per_col]
// [START bigtable_filters_limit_cells_per_row]
// [START bigtable_filters_limit_cells_per_row_offset]
// [START bigtable_filters_limit_col_family_regex]
// [START bigtable_filters_limit_col_qualifier_regex]
// [START bigtable_filters_limit_col_range]
// [START bigtable_filters_limit_value_range]
// [START bigtable_filters_limit_value_regex]
// [START bigtable_filters_limit_timestamp_range]
// [START bigtable_filters_limit_block_all]
// [START bigtable_filters_limit_pass_all]
// [START bigtable_filters_limit_sink]
// [START bigtable_filters_modify_strip_value]
// [START bigtable_filters_modify_apply_label]
// [START bigtable_filters_composing_chain]
// [START bigtable_filters_composing_interleave]
// [START bigtable_filters_composing_condition]
import com.google.api.gax.rpc.ServerStream;
import com.google.cloud.bigtable.data.v2.BigtableDataClient;
import com.google.cloud.bigtable.data.v2.models.Filters.Filter;
import com.google.cloud.bigtable.data.v2.models.Query;
import com.google.cloud.bigtable.data.v2.models.Row;
import com.google.cloud.bigtable.data.v2.models.RowCell;

public class Filters {
  // [END bigtable_filters_limit_row_sample]
  // [END bigtable_filters_limit_row_regex]
  // [END bigtable_filters_limit_cells_per_col]
  // [END bigtable_filters_limit_cells_per_row]
  // [END bigtable_filters_limit_cells_per_row_offset]
  // [END bigtable_filters_limit_col_family_regex]
  // [END bigtable_filters_limit_col_qualifier_regex]
  // [END bigtable_filters_limit_col_range]
  // [END bigtable_filters_limit_value_range]
  // [END bigtable_filters_limit_value_regex]
  // [END bigtable_filters_limit_timestamp_range]
  // [END bigtable_filters_limit_block_all]
  // [END bigtable_filters_limit_pass_all]
  // [END bigtable_filters_limit_sink]
  // [END bigtable_filters_modify_strip_value]
  // [END bigtable_filters_modify_apply_label]
  // [END bigtable_filters_composing_chain]
  // [END bigtable_filters_composing_interleave]
  // [END bigtable_filters_composing_condition]

  // [START bigtable_filters_limit_row_sample]
  public static void filterLimitRowSample(String projectId, String instanceId, String tableId) {
    // String projectId = "my-project-id";
    // String instanceId = "my-instance-id";
    // String tableId = "mobile-time-series";

    Filter filter = FILTERS.key().sample(.5);
    readFilter(projectId, instanceId, tableId, filter);
  }
  // [END bigtable_filters_limit_row_sample]

  // [START bigtable_filters_limit_row_regex]
  public static void filterLimitRowRegex(String projectId, String instanceId, String tableId) {
    // String projectId = "my-project-id";
    // String instanceId = "my-instance-id";
    // String tableId = "mobile-time-series";

    Filter filter = FILTERS.key().regex(".*#20190501$");
    readFilter(projectId, instanceId, tableId, filter);
  }
  // [END bigtable_filters_limit_row_regex]

  // [START bigtable_filters_limit_cells_per_col]
  public static void filterLimitCellsPerCol(String projectId, String instanceId, String tableId) {
    // String projectId = "my-project-id";
    // String instanceId = "my-instance-id";
    // String tableId = "mobile-time-series";

    Filter filter = FILTERS.limit().cellsPerColumn(2);
    readFilter(projectId, instanceId, tableId, filter);
  }
  // [END bigtable_filters_limit_cells_per_col]

  // [START bigtable_filters_limit_cells_per_row]
  public static void filterLimitCellsPerRow(String projectId, String instanceId, String tableId) {
    // String projectId = "my-project-id";
    // String instanceId = "my-instance-id";
    // String tableId = "mobile-time-series";

    Filter filter = FILTERS.limit().cellsPerRow(2);
    readFilter(projectId, instanceId, tableId, filter);
  }
  // [END bigtable_filters_limit_cells_per_row]

  // [START bigtable_filters_limit_cells_per_row_offset]
  public static void filterLimitCellsPerRowOffset(
      String projectId, String instanceId, String tableId) {
    // String projectId = "my-project-id";
    // String instanceId = "my-instance-id";
    // String tableId = "mobile-time-series";

    Filter filter = FILTERS.offset().cellsPerRow(2);
    readFilter(projectId, instanceId, tableId, filter);
  }
  // [END bigtable_filters_limit_cells_per_row_offset]

  // [START bigtable_filters_limit_col_family_regex]
  public static void filterLimitColFamilyRegex(
      String projectId, String instanceId, String tableId) {
    // String projectId = "my-project-id";
    // String instanceId = "my-instance-id";
    // String tableId = "mobile-time-series";

    Filter filter = FILTERS.family().regex("stats_.*$");
    readFilter(projectId, instanceId, tableId, filter);
  }
  // [END bigtable_filters_limit_col_family_regex]

  // [START bigtable_filters_limit_col_qualifier_regex]
  public static void filterLimitColQualifierRegex(
      String projectId, String instanceId, String tableId) {
    // String projectId = "my-project-id";
    // String instanceId = "my-instance-id";
    // String tableId = "mobile-time-series";

    Filter filter = FILTERS.qualifier().regex("connected_.*$");
    readFilter(projectId, instanceId, tableId, filter);
  }
  // [END bigtable_filters_limit_col_qualifier_regex]

  // [START bigtable_filters_limit_col_range]
  public static void filterLimitColRange(String projectId, String instanceId, String tableId) {
    // String projectId = "my-project-id";
    // String instanceId = "my-instance-id";
    // String tableId = "mobile-time-series";

    Filter filter =
        FILTERS
            .qualifier()
            .rangeWithinFamily("cell_plan")
            .startClosed("data_plan_01gb")
            .endOpen("data_plan_10gb");
    readFilter(projectId, instanceId, tableId, filter);
  }
  // [END bigtable_filters_limit_col_range]

  // [START bigtable_filters_limit_value_range]
  public static void filterLimitValueRange(String projectId, String instanceId, String tableId) {
    // String projectId = "my-project-id";
    // String instanceId = "my-instance-id";
    // String tableId = "mobile-time-series";

    Filter filter = FILTERS.value().range().startClosed("PQ2A.190405").endClosed("PQ2A.190406");
    readFilter(projectId, instanceId, tableId, filter);
  }
  // [END bigtable_filters_limit_value_range]

  // [START bigtable_filters_limit_value_regex]
  public static void filterLimitValueRegex(String projectId, String instanceId, String tableId) {
    // String projectId = "my-project-id";
    // String instanceId = "my-instance-id";
    // String tableId = "mobile-time-series";

    Filter filter = FILTERS.value().regex("PQ2A.*$");
    readFilter(projectId, instanceId, tableId, filter);
  }
  // [END bigtable_filters_limit_value_regex]

  // [START bigtable_filters_limit_timestamp_range]
  public static void filterLimitTimestampRange(
      String projectId, String instanceId, String tableId) {
    // String projectId = "my-project-id";
    // String instanceId = "my-instance-id";
    // String tableId = "mobile-time-series";
    long timestamp = System.currentTimeMillis() * 1000;
    long hour = 60L * 60 * 1000 * 1000;

    Filter filter = FILTERS.timestamp().range().startClosed(0L).endOpen(timestamp - hour);
    readFilter(projectId, instanceId, tableId, filter);
  }
  // [END bigtable_filters_limit_timestamp_range]

  // [START bigtable_filters_limit_block_all]
  public static void filterLimitBlockAll(String projectId, String instanceId, String tableId) {
    // String projectId = "my-project-id";
    // String instanceId = "my-instance-id";
    // String tableId = "mobile-time-series";

    Filter filter = FILTERS.block();
    readFilter(projectId, instanceId, tableId, filter);
  }
  // [END bigtable_filters_limit_block_all]

  // [START bigtable_filters_limit_pass_all]
  public static void filterLimitPassAll(String projectId, String instanceId, String tableId) {
    // String projectId = "my-project-id";
    // String instanceId = "my-instance-id";
    // String tableId = "mobile-time-series";

    Filter filter = FILTERS.pass();
    readFilter(projectId, instanceId, tableId, filter);
  }
  // [END bigtable_filters_limit_pass_all]

  // [START bigtable_filters_limit_sink]
  public static void filterLimitSink(String projectId, String instanceId, String tableId) {
    // String projectId = "my-project-id";
    // String instanceId = "my-instance-id";
    // String tableId = "mobile-time-series";

    Filter filter = FILTERS.sink();
    readFilter(projectId, instanceId, tableId, filter);
  }
  // [END bigtable_filters_limit_sink]

  // [START bigtable_filters_modify_strip_value]
  public static void filterModifyStripValue(String projectId, String instanceId, String tableId) {
    // String projectId = "my-project-id";
    // String instanceId = "my-instance-id";
    // String tableId = "mobile-time-series";

    Filter filter = FILTERS.value().strip();
    readFilter(projectId, instanceId, tableId, filter);
  }
  // [END bigtable_filters_modify_strip_value]

  // [START bigtable_filters_modify_apply_label]
  public static void filterModifyApplyLabel(String projectId, String instanceId, String tableId) {
    // String projectId = "my-project-id";
    // String instanceId = "my-instance-id";
    // String tableId = "mobile-time-series";

    Filter filter = FILTERS.label("my-label");
    readFilter(projectId, instanceId, tableId, filter);
  }
  // [END bigtable_filters_modify_apply_label]

  // [START bigtable_filters_composing_chain]
  public static void filterComposingChain(String projectId, String instanceId, String tableId) {
    // String projectId = "my-project-id";
    // String instanceId = "my-instance-id";
    // String tableId = "mobile-time-series";

    Filter filter =
        FILTERS
            .chain()
            .filter(FILTERS.limit().cellsPerColumn(1))
            .filter(FILTERS.family().exactMatch("cell_plan"));
    readFilter(projectId, instanceId, tableId, filter);
  }
  // [END bigtable_filters_composing_chain]

  // [START bigtable_filters_composing_interleave]
  public static void filterComposingInterleave(
      String projectId, String instanceId, String tableId) {
    // String projectId = "my-project-id";
    // String instanceId = "my-instance-id";
    // String tableId = "mobile-time-series";

    Filter filter =
        FILTERS
            .interleave()
            .filter(FILTERS.limit().cellsPerColumn(1))
            .filter(FILTERS.family().exactMatch("cell_plan"));
    readFilter(projectId, instanceId, tableId, filter);
  }
  // [END bigtable_filters_composing_interleave]

  // [START bigtable_filters_composing_condition]
  public static void filterComposingCondition(String projectId, String instanceId, String tableId) {
    // String projectId = "my-project-id";
    // String instanceId = "my-instance-id";
    // String tableId = "mobile-time-series";

    Filter filter =
        FILTERS
            .condition(FILTERS.value().regex("PQ2A.*$"))
            .otherwise(FILTERS.label("my-label2"))
            .then(FILTERS.label("my-label"));
    readFilter(projectId, instanceId, tableId, filter);
  }
  // [END bigtable_filters_composing_condition]

  // [START bigtable_filters_limit_row_sample]
  // [START bigtable_filters_limit_row_regex]
  // [START bigtable_filters_limit_cells_per_col]
  // [START bigtable_filters_limit_cells_per_row]
  // [START bigtable_filters_limit_cells_per_row_offset]
  // [START bigtable_filters_limit_col_family_regex]
  // [START bigtable_filters_limit_col_qualifier_regex]
  // [START bigtable_filters_limit_col_range]
  // [START bigtable_filters_limit_value_range]
  // [START bigtable_filters_limit_value_regex]
  // [START bigtable_filters_limit_timestamp_range]
  // [START bigtable_filters_limit_block_all]
  // [START bigtable_filters_limit_pass_all]
  // [START bigtable_filters_limit_sink]
  // [START bigtable_filters_modify_strip_value]
  // [START bigtable_filters_modify_apply_label]
  // [START bigtable_filters_composing_chain]
  // [START bigtable_filters_composing_interleave]
  // [START bigtable_filters_composing_condition]
  public static void readFilter(
      String projectId, String instanceId, String tableId, Filter filter) {
    try (BigtableDataClient dataClient = BigtableDataClient.create(projectId, instanceId)) {
      Query query = Query.create(tableId).filter(filter);
      ServerStream<Row> rows = dataClient.readRows(query);
      for (Row row : rows) {
        printRow(row);
      }

    } catch (Exception e) {
      System.out.println("Error during readFilter: \n" + e.toString());
    }
  }

  private static void printRow(Row row) {
    System.out.printf("Reading data for %s%n", row.getKey().toStringUtf8());
    String colFamily = "";
    for (RowCell cell : row.getCells()) {
      if (cell.getFamily() != colFamily) {
        colFamily = cell.getFamily();
        System.out.printf("Column Family %s%n", colFamily);
      }
      String labels =
          cell.getLabels().size() == 0 ? "" : " [" + String.join(",", cell.getLabels()) + "]";
      System.out.printf(
          "\t%s: %s @%s%s%n",
          cell.getQualifier().toStringUtf8(),
          cell.getValue().toStringUtf8(),
          cell.getTimestamp(),
          labels);
    }
    System.out.println();
  }
}
// [END bigtable_filters_limit_row_sample]
// [END bigtable_filters_limit_row_regex]
// [END bigtable_filters_limit_cells_per_col]
// [END bigtable_filters_limit_cells_per_row]
// [END bigtable_filters_limit_cells_per_row_offset]
// [END bigtable_filters_limit_col_family_regex]
// [END bigtable_filters_limit_col_qualifier_regex]
// [END bigtable_filters_limit_col_range]
// [END bigtable_filters_limit_value_range]
// [END bigtable_filters_limit_value_regex]
// [END bigtable_filters_limit_timestamp_range]
// [END bigtable_filters_limit_block_all]
// [END bigtable_filters_limit_pass_all]
// [END bigtable_filters_limit_sink]
// [END bigtable_filters_modify_strip_value]
// [END bigtable_filters_modify_apply_label]
// [END bigtable_filters_composing_chain]
// [END bigtable_filters_composing_interleave]
// [END bigtable_filters_composing_condition]
