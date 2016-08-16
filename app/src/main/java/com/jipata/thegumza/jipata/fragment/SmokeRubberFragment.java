package com.jipata.thegumza.jipata.fragment;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.LargeValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.jipata.thegumza.jipata.R;
import com.jipata.thegumza.jipata.adapter.RubberPriceAdapter;

import java.util.ArrayList;


/**
 * Created by thegumza on 08/15/2016.
 */
public class SmokeRubberFragment extends Fragment {

    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    RubberPriceAdapter adapter;
    BarChart mChart;
    ArrayList<BarEntry> yVals1;
    ArrayList<String> xVals;
    BarData data;
    Typeface tf;
    String[] province = new String[]{"สงขลา", "สุราษฎร์ธานี", "นครศรีธรรมราช", "ยะลา"};


    public SmokeRubberFragment() {
        super();
    }

    public static SmokeRubberFragment newInstance() {
        SmokeRubberFragment fragment = new SmokeRubberFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(savedInstanceState);

        if (savedInstanceState != null)
            onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_rubber, container, false);
        initInstances(rootView, savedInstanceState);
        linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new RubberPriceAdapter();
        recyclerView.setAdapter(adapter);
        initChartData();
        return rootView;
    }

    @SuppressWarnings("UnusedParameters")
    private void init(Bundle savedInstanceState) {
        // Init Fragment level's variable(s) here
    }

    @SuppressWarnings("UnusedParameters")
    private void initInstances(View rootView, Bundle savedInstanceState) {
        // Init 'View' instance(s) with rootView.findViewById here
        // Note: State of variable initialized here could not be saved
        //       in onSavedInstanceState
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        mChart = (BarChart) rootView.findViewById(R.id.mChart);
    }

    public void initChartData() {
        xVals = new ArrayList<String>();
        yVals1 = new ArrayList<BarEntry>();
        for (int i = 0; i < 4; i++) {
            xVals.add(province[i]);
        }

        for (int i = 0; i < 4; i++) {
            float val1 = (float) 50 * (i + 1);

            yVals1.add(new BarEntry(new float[]{val1}, i));

        }

        if (mChart.getData() != null &&
                mChart.getData().getDataSetCount() > 0) {
            mChart.clear();
        }

        BarDataSet set1;

        set1 = new BarDataSet(yVals1, "");

        set1.setColors(getResources().getIntArray(R.array.chart_color));

        set1.setDrawValues(true);
        set1.setValueTextSize(16f);
        set1.setValueTextColor(ContextCompat.getColor(getActivity(), R.color.textColor));

        ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();
        dataSets.add(set1);

        data = new BarData(xVals, dataSets);
        data.setValueFormatter(new LargeValueFormatter());


        mChart.setDescription("");
        mChart.setTouchEnabled(false);
        mChart.setPinchZoom(false);
        mChart.setDrawBarShadow(false);
        mChart.setDrawGridBackground(false);
        mChart.setDoubleTapToZoomEnabled(false);
        mChart.setEnabled(false);
        mChart.setClickable(false);
        mChart.setNoDataText("No Data");
        mChart.setExtraOffsets(0, 10, 0, 10);

        XAxis xl = mChart.getXAxis();
        YAxis leftAxis = mChart.getAxisLeft();
        Legend legend = mChart.getLegend();
        try {
            tf = Typeface.createFromAsset(getActivity().getAssets(), getActivity().getResources().getString(R.string.font));
            xl.setTypeface(tf);
            leftAxis.setTypeface(tf);
            set1.setValueTypeface(tf);
            data.setValueTypeface(tf);
            legend.setTypeface(tf);
        } catch (Resources.NotFoundException e) {
            e.printStackTrace();
        }

        xl.setPosition(XAxis.XAxisPosition.BOTTOM);
        xl.setDrawGridLines(false);
        xl.setAxisLineColor(ContextCompat.getColor(getActivity(), R.color.dividerColor));
        xl.setTextColor(ContextCompat.getColor(getActivity(), R.color.textColor));
        xl.setTextSize(16f);
        xl.setLabelsToSkip(0);


        leftAxis.setValueFormatter(new LargeValueFormatter());
        leftAxis.setDrawGridLines(false);
        leftAxis.setAxisLineColor(ContextCompat.getColor(getActivity(), R.color.dividerColor));
        leftAxis.setTextColor(ContextCompat.getColor(getActivity(), R.color.textColor));
        leftAxis.setTextSize(14f);

        mChart.getAxisRight().setEnabled(false);
        mChart.getXAxis().setDrawGridLines(false);

        legend.setFormSize(12f);
        legend.setTextColor(ContextCompat.getColor(getActivity(), R.color.textColor));
        legend.setTextSize(12f);
        legend.setCustom(getResources().getIntArray(R.array.chart_color), province);
        legend.setYOffset(10f);
        legend.setXEntrySpace(10f);
        legend.setEnabled(false);
        mChart.animateXY(750, 750);
        mChart.setData(data);
        mChart.invalidate();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save Instance (Fragment level's variables) State here
    }

    @SuppressWarnings("UnusedParameters")
    private void onRestoreInstanceState(Bundle savedInstanceState) {
        // Restore Instance (Fragment level's variables) State here
    }

    @Override
    public void setMenuVisibility(final boolean visible) {
        super.setMenuVisibility(visible);
        if (visible && mChart != null && adapter !=null) {
        }
    }
}
