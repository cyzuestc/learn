package ink.cyz.use.spider;

import cn.hutool.core.io.FileUtil;
import cn.hutool.http.HttpUtil;

import java.util.ArrayList;

/**
 * @Date 2019/5/14 11:45
 * @AUTHOR cyz.ink
 **/
public class PicDownload2 {
    public static void main(String[] args) {
        String url = "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7N631hbStibHBYJicPyqRD2xdESFJHFq56Pb3e7swRwYPAN5CPib4Qnz0zUIHXd1pDFtVuXVN1BxJS2A/640?wx_fmt=jpeg," +
                "," +
                "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7OGQCs7CPKpkDoSDtezuEj0J7o8XJDcsco1Nnvoeibqk2XibuRnkg4JZZSRRiblP0FB9jvfqicJ3GrXAA/640?wx_fmt=jpeg," +
                "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7OGQCs7CPKpkDoSDtezuEj0DxI00uKnCbOaTrXGhSeGvWuiajTG9BQIesOanIes2ibA6kdWNB89gMLQ/640?wx_fmt=jpeg," +
                "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7OGQCs7CPKpkDoSDtezuEj0yibWMbmxQ7DAMnbicmrTyAGoEicYPd03ibUR6HdLrb7aE3VXIDzJ7y9EIQ/640?wx_fmt=jpeg," +
                "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7OGQCs7CPKpkDoSDtezuEj0wqvOVcs9rzVGIr99JBFlia78JeZ5Ek8jz8vQzuPEX3MlyWghicEgwxtw/640?wx_fmt=jpeg," +
                "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7OGQCs7CPKpkDoSDtezuEj0MZMzQkJrN74x6ViaOBBNqicv9GJfERo3sWdUpE9Uk3phFncWMWeatuTw/640?wx_fmt=jpeg," +
                "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7OGQCs7CPKpkDoSDtezuEj0j9mBH1ewV5Tiaqqp1mXk2VoDuwZBMYYZfW8lvAFw1Z91Jec1IjPOxAQ/640?wx_fmt=jpeg," +
                "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7OGQCs7CPKpkDoSDtezuEj0KFSCcOcS6gl12pPWa48NicoconVJ2iaRuy81gTMHLPiapic5tfQFD1cyXw/640?wx_fmt=jpeg," +
                "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7OGQCs7CPKpkDoSDtezuEj0m4QQZia5qUdWicBWhz81AbIhQTxjicmOS3o8UI2mJfS9yJAHkeicQAmzJA/640?wx_fmt=jpeg," +
                "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7OGQCs7CPKpkDoSDtezuEj0ibnUnKDgjF2vicCoUD95Jr1UvKsoUtOuG5RFoibibSel8hWFIxC6Kn46WA/640?wx_fmt=jpeg," +
                "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7OGQCs7CPKpkDoSDtezuEj0iaAWY9icVghjkibXo6oGIfmtPaVFvJQwolSOC2XjFZ3FQ6fTETKXraeCQ/640?wx_fmt=jpeg," +
                "," +
                "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7N631hbStibHBYJicPyqRD2xdESFJHFq56Pb3e7swRwYPAN5CPib4Qnz0zUIHXd1pDFtVuXVN1BxJS2A/640?wx_fmt=jpeg," +
                "," +
                "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7O52reuQSibm7BUX9QdXyLT2ldGTD2pWnNCpmsKsLI8W5OIyJWd7OA2eCCib9BhFrO3TjZkkW91pAFA/640?wx_fmt=jpeg," +
                "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7O52reuQSibm7BUX9QdXyLT2ep7I9uicvSSP0iamUAHsyaawyox1GntwPFQ9IV8hfQwtAdoX04p91TDQ/640?wx_fmt=jpeg," +
                "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7O52reuQSibm7BUX9QdXyLT2v4L8RXrXrkBicXvlSzmqGWPRQPKENFiaO4kDrrAcPKt8Txe83vHVxWKg/640?wx_fmt=jpeg," +
                "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7O52reuQSibm7BUX9QdXyLT2WiaUhiccDIEbjuRoHkdDgbTOxIIS3WiabTZmI90LwLPN0CstAXjW103OA/640?wx_fmt=jpeg," +
                "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7O52reuQSibm7BUX9QdXyLT2uRqtwGXFd5uuVyTWdlYW4kH9Bnia8jEuWndrddUZkrolQS0PHH5hfEQ/640?wx_fmt=jpeg," +
                "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7O52reuQSibm7BUX9QdXyLT2yj8kz0IvdoV8TMcrnWnUdnhdNibUjszvvlEy0GM91PibmXp0CoZAiafEg/640?wx_fmt=jpeg," +
                "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7O52reuQSibm7BUX9QdXyLT23QGxWAHg4MZeC65icA5soxsUcO1vdibm0hF4aB0u7OO9pujRvLyz5n8Q/640?wx_fmt=jpeg," +
                "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7O52reuQSibm7BUX9QdXyLT2Qz1wUNYENOyEOvhMFuwCEwtMTGqZ9v1h6gk6vXSvZ663ClMVia9qKmw/640?wx_fmt=jpeg," +
                "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7O52reuQSibm7BUX9QdXyLT2lE1RuGSgMVMRH3fPuTjYRJKTIQiciaZeUWsZeibic4zqPzh8kJOlksufPQ/640?wx_fmt=jpeg," +
                "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7O52reuQSibm7BUX9QdXyLT2HExr4Cmv6vL66mVTDNicV5vpvGsiaHia1jibImgaKhibxKnLWumXyPTicnew/640?wx_fmt=jpeg," +
                "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7O52reuQSibm7BUX9QdXyLT2ZlM8YzONzmd4ibQERYnsIEOO1I9nITGR1Teq162EUeDpiaHVRjoZluJw/640?wx_fmt=jpeg," +
                "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7O52reuQSibm7BUX9QdXyLT2IodJCSa8JFTSoUPVPUeGV5oibUsWsv4Al8LVYGPoaana8LRnYWQzviaQ/640?wx_fmt=jpeg," +
                "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7O52reuQSibm7BUX9QdXyLT2Wjicia0AUHNkjlCIeIPlTm9gDQiabkRzoYxKC3BhwRNgdhDCzzcl58gpQ/640?wx_fmt=jpeg," +
                "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7O52reuQSibm7BUX9QdXyLT2QrWePQDzcRFehjktq4CobxOvKnLzLFN9N70Nst7vOQOsm8DiarQuUJw/640?wx_fmt=jpeg," +
                "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7OGQCs7CPKpkDoSDtezuEj0iaAWY9icVghjkibXo6oGIfmtPaVFvJQwolSOC2XjFZ3FQ6fTETKXraeCQ/640?wx_fmt=jpeg," +
                "," +
                "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7N631hbStibHBYJicPyqRD2xdESFJHFq56Pb3e7swRwYPAN5CPib4Qnz0zUIHXd1pDFtVuXVN1BxJS2A/640?wx_fmt=jpeg," +
                "," +
                "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7O52reuQSibm7BUX9QdXyLT2ldGTD2pWnNCpmsKsLI8W5OIyJWd7OA2eCCib9BhFrO3TjZkkW91pAFA/640?wx_fmt=jpeg," +
                "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7O52reuQSibm7BUX9QdXyLT2ep7I9uicvSSP0iamUAHsyaawyox1GntwPFQ9IV8hfQwtAdoX04p91TDQ/640?wx_fmt=jpeg," +
                "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7O52reuQSibm7BUX9QdXyLT2v4L8RXrXrkBicXvlSzmqGWPRQPKENFiaO4kDrrAcPKt8Txe83vHVxWKg/640?wx_fmt=jpeg," +
                "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7O52reuQSibm7BUX9QdXyLT2WiaUhiccDIEbjuRoHkdDgbTOxIIS3WiabTZmI90LwLPN0CstAXjW103OA/640?wx_fmt=jpeg," +
                "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7O52reuQSibm7BUX9QdXyLT2uRqtwGXFd5uuVyTWdlYW4kH9Bnia8jEuWndrddUZkrolQS0PHH5hfEQ/640?wx_fmt=jpeg," +
                "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7O52reuQSibm7BUX9QdXyLT2yj8kz0IvdoV8TMcrnWnUdnhdNibUjszvvlEy0GM91PibmXp0CoZAiafEg/640?wx_fmt=jpeg," +
                "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7O52reuQSibm7BUX9QdXyLT23QGxWAHg4MZeC65icA5soxsUcO1vdibm0hF4aB0u7OO9pujRvLyz5n8Q/640?wx_fmt=jpeg," +
                "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7O52reuQSibm7BUX9QdXyLT2Qz1wUNYENOyEOvhMFuwCEwtMTGqZ9v1h6gk6vXSvZ663ClMVia9qKmw/640?wx_fmt=jpeg," +
                "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7O52reuQSibm7BUX9QdXyLT2lE1RuGSgMVMRH3fPuTjYRJKTIQiciaZeUWsZeibic4zqPzh8kJOlksufPQ/640?wx_fmt=jpeg," +
                "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7O52reuQSibm7BUX9QdXyLT2HExr4Cmv6vL66mVTDNicV5vpvGsiaHia1jibImgaKhibxKnLWumXyPTicnew/640?wx_fmt=jpeg," +
                "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7O52reuQSibm7BUX9QdXyLT2ZlM8YzONzmd4ibQERYnsIEOO1I9nITGR1Teq162EUeDpiaHVRjoZluJw/640?wx_fmt=jpeg," +
                "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7O52reuQSibm7BUX9QdXyLT2IodJCSa8JFTSoUPVPUeGV5oibUsWsv4Al8LVYGPoaana8LRnYWQzviaQ/640?wx_fmt=jpeg," +
                "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7O52reuQSibm7BUX9QdXyLT2Wjicia0AUHNkjlCIeIPlTm9gDQiabkRzoYxKC3BhwRNgdhDCzzcl58gpQ/640?wx_fmt=jpeg," +
                "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7O52reuQSibm7BUX9QdXyLT2QrWePQDzcRFehjktq4CobxOvKnLzLFN9N70Nst7vOQOsm8DiarQuUJw/640?wx_fmt=jpeg," +
                "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7OGQCs7CPKpkDoSDtezuEj0iaAWY9icVghjkibXo6oGIfmtPaVFvJQwolSOC2XjFZ3FQ6fTETKXraeCQ/640?wx_fmt=jpeg," +
                "," +
                "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7N631hbStibHBYJicPyqRD2xdESFJHFq56Pb3e7swRwYPAN5CPib4Qnz0zUIHXd1pDFtVuXVN1BxJS2A/640?wx_fmt=jpeg," +
                "," +
                "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7O52reuQSibm7BUX9QdXyLT2ZDeSmfic0ISvLKNkLpr73FDyb7ODOica2Wnbv0z0V0aVZPDic0iaEcNSew/640?wx_fmt=jpeg," +
                "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7O52reuQSibm7BUX9QdXyLT2kbZHEQIZCQ1VhBkCbbo1yLmCricQzIyicJAYd8NGAjXq1Ajx48F88BcA/640?wx_fmt=jpeg," +
                "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7O52reuQSibm7BUX9QdXyLT29bz1EtRECk6L3IKsxzp3JtYJrnT0JfSOKzYI8qtLwEdibevoibWF1gkg/640?wx_fmt=jpeg," +
                "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7O52reuQSibm7BUX9QdXyLT2jTzS6tV4iadla23SmleCdZHulbaZNCNCOXUuh3US2iaTTiaViaib1ZdfqSw/640?wx_fmt=jpeg," +
                "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7O52reuQSibm7BUX9QdXyLT2gDTmCKM2QVKlkmlVHncRGg3OgDQYmuuzRXYp0tlHJicdcghs0yQRibmg/640?wx_fmt=jpeg," +
                "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7O52reuQSibm7BUX9QdXyLT26f4KvNSRU2foFvfUDwz76wsyFhyzf1icbmiaQSCfBmPaiadfGVF7sjicow/640?wx_fmt=jpeg," +
                "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7O52reuQSibm7BUX9QdXyLT2FZsibRickYyNA1HiaJblGPy2nDbjAXYvVllfWn8HeiaKtHS8oMLWibHnBGA/640?wx_fmt=jpeg," +
                "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7O52reuQSibm7BUX9QdXyLT2prCtfGIxiapGHUqTXjVFG71et6ANQBkgFibiaCafUicu3cjRnmkzzgVc9Q/640?wx_fmt=jpeg," +
                "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7O52reuQSibm7BUX9QdXyLT2TicjPxy511UNybGHzjibob9qicU7aL9XC2MRnnDPkWKD7qsh1fK76DXQg/640?wx_fmt=jpeg," +
                "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7O52reuQSibm7BUX9QdXyLT28iboOZAgowpNrhCuiawiazegRhktgwFTdmQ5rXcICuPyicdUXQWHHax2oA/640?wx_fmt=jpeg," +
                "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7O52reuQSibm7BUX9QdXyLT2yASEucibvExO9bvibOQ5CdqficL66Kp0HqM5Uejofd9OMUibXvm3BibHAKw/640?wx_fmt=jpeg," +
                "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7O52reuQSibm7BUX9QdXyLT2k0nOGOKkrfk7DdDJqrcvWFzhjC8frv1OAtg7Y58E6gaBibR0rSX7Kxw/640?wx_fmt=jpeg," +
                "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7O52reuQSibm7BUX9QdXyLT2FyER4nR23QCfBRcMP2ZVXG0VeMUpYuYeiakdJuFdco2ud0ygOibocn7Q/640?wx_fmt=jpeg," +
                "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7O52reuQSibm7BUX9QdXyLT2l2hU3tGZYTBZuG31NlQ6jrbuyj5cAbQYZERxFX7hSAm7WReEGtgyuQ/640?wx_fmt=jpeg," +
                "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7OGQCs7CPKpkDoSDtezuEj0iaAWY9icVghjkibXo6oGIfmtPaVFvJQwolSOC2XjFZ3FQ6fTETKXraeCQ/640?wx_fmt=jpeg," +
                "," +
                "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7N631hbStibHBYJicPyqRD2xdESFJHFq56Pb3e7swRwYPAN5CPib4Qnz0zUIHXd1pDFtVuXVN1BxJS2A/640?wx_fmt=jpeg," +
                "," +
                "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7OGQCs7CPKpkDoSDtezuEj0x7iaqQGYWBUKe3JbGU2xxIz5q72fqRwKBRu73rIVfeFiaSaNtE6AVqicg/640?wx_fmt=jpeg," +
                "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7OGQCs7CPKpkDoSDtezuEj0Wnw0e6Kx275NU4gHjr1G0xYYiaVZdDgicLTiaJdC8NQjjHuUwCRKSyKbQ/640?wx_fmt=jpeg," +
                "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7OGQCs7CPKpkDoSDtezuEj0j59Bh9wk9N1RCm0ZfNPLhBic7us5Tv64jEKIxM7zvdSCZB7qZ11Gn2A/640?wx_fmt=jpeg," +
                "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7OGQCs7CPKpkDoSDtezuEj0hl71FolfvoEbViaMQ9hpf7X16w9SXJvhmvqAYPmBYNVxnuJst3bkkTg/640?wx_fmt=jpeg," +
                "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7OGQCs7CPKpkDoSDtezuEj0Vl1ajHMupBsFGo47iaob8KTk8BQUsSTfJXdiaz1Vbnrjgp3Ty8m5a3OQ/640?wx_fmt=jpeg," +
                "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7OGQCs7CPKpkDoSDtezuEj0iaAWY9icVghjkibXo6oGIfmtPaVFvJQwolSOC2XjFZ3FQ6fTETKXraeCQ/640?wx_fmt=jpeg," +
                "," +
                "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7N631hbStibHBYJicPyqRD2xdESFJHFq56Pb3e7swRwYPAN5CPib4Qnz0zUIHXd1pDFtVuXVN1BxJS2A/640?wx_fmt=jpeg," +
                "," +
                "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7OGQCs7CPKpkDoSDtezuEj07uCoOYt0yObfugVfmZgpCdDKS1DbUkiaD3tjicibI8DfNs3WKFvSiaBnlA/640?wx_fmt=jpeg," +
                "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7OGQCs7CPKpkDoSDtezuEj07PBaWM76WvRJnyuB0GcC1jpicLpZ8q1x0J2Kno6j5WAT2nBAuHGu3WQ/640?wx_fmt=jpeg," +
                "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7OGQCs7CPKpkDoSDtezuEj0qoaKhPHSGTXicbQHRNgPwlhSPAyfkmiaZRjubIL8Bqg9HA6qB8IbS2Yg/640?wx_fmt=jpeg," +
                "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7OGQCs7CPKpkDoSDtezuEj0QUSphtViacsu9HCYNRpba1zjb2oPBVmRKvO0OsymNoQreAbsB4Z5Fjg/640?wx_fmt=jpeg," +
                "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7OGQCs7CPKpkDoSDtezuEj0iaC2kPtZhbQdg54oEh8yp9s7wPiaJEBVMbicc8micPvIOVFSF8CJrOv3mA/640?wx_fmt=jpeg," +
                "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7OGQCs7CPKpkDoSDtezuEj0G6kdw1ibYZKK3xLiavgctjJjUo9WseUadMJJ642VrlEsWc0rzFPhNNjA/640?wx_fmt=jpeg," +
                "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7OGQCs7CPKpkDoSDtezuEj0jStLkIGljiasByibbExChicphMp7RfN2K9oymY72436aMib75MsqN8GWnw/640?wx_fmt=jpeg," +
                "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7OGQCs7CPKpkDoSDtezuEj0zSCUJsPGm2QAtuMDjHKvlWaAzzcYxNzt3FxQ1oyglXy1nz7CUEZsHA/640?wx_fmt=jpeg," +
                "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7OGQCs7CPKpkDoSDtezuEj0iaAWY9icVghjkibXo6oGIfmtPaVFvJQwolSOC2XjFZ3FQ6fTETKXraeCQ/640?wx_fmt=jpeg," +
                "," +
                "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7N631hbStibHBYJicPyqRD2xdESFJHFq56Pb3e7swRwYPAN5CPib4Qnz0zUIHXd1pDFtVuXVN1BxJS2A/640?wx_fmt=jpeg," +
                "," +
                "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7OGQCs7CPKpkDoSDtezuEj0pNy6JUsO4paaibIianvSib4hNNVtwd8V7KmH5kNohVGveuhgrALVgVhuA/640?wx_fmt=jpeg," +
                "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7OGQCs7CPKpkDoSDtezuEj0HaqduHqtYeKsCyopx7QkV1bPu1oAY34x1QQHY881ImaANfdJLznj2g/640?wx_fmt=jpeg," +
                "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7OGQCs7CPKpkDoSDtezuEj0BicwtBXpum84vAQE8wjhUiaLKkhnmPZwF0BAicjiakDllHPgnv1YuZRGHw/640?wx_fmt=jpeg," +
                "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7OGQCs7CPKpkDoSDtezuEj0tBy1jWQX9sG4Gu0Kbc94XPApGdZia3aVyefviagtr1eI5iaeJrd40iag0w/640?wx_fmt=jpeg," +
                "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7OGQCs7CPKpkDoSDtezuEj0A6fmqzEIevicMLeA57ChZzdf9PZDbKFs5NxdZEuoZvJobibibgaZknAOg/640?wx_fmt=jpeg," +
                "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7OGQCs7CPKpkDoSDtezuEj0231RvMWMG5vgcml8VcTAUZI8kd5dEsGOicww1Sq1nLQEWWxL6xibQuJQ/640?wx_fmt=jpeg," +
                "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7OGQCs7CPKpkDoSDtezuEj0gMKynQ0b2pCgwMf0DMN5vFiaNLo3hH1liaibsNcCB7JlMBvRQkpfkhQww/640?wx_fmt=jpeg," +
                "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7OGQCs7CPKpkDoSDtezuEj0Mwydj4hgyKricuicWerlEQG4HnxmdL5cXXx8QS0qB5qrBrK1ZbkIktcQ/640?wx_fmt=jpeg," +
                "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7OGQCs7CPKpkDoSDtezuEj03KVGSjYlwU8w8vKFfanF8LRuslx3N8ricNmQDDXqL9Qh5XniaFSMZyuA/640?wx_fmt=jpeg," +
                "https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7OGQCs7CPKpkDoSDtezuEj0iaAWY9icVghjkibXo6oGIfmtPaVFvJQwolSOC2XjFZ3FQ6fTETKXraeCQ/640?wx_fmt=jpeg,";
        String[] urls = url.split(",");
        for (int i = urls.length-1; i >=0 ; i--) {
            if (!urls[i].trim().isEmpty() && !urls[i].contains("cv64e2mCy7N631hbStibHBYJicPyqRD2xdESFJHFq56Pb3e7swRwYPAN5CPib4Qnz0zUIHXd1pDFtVuXVN1BxJS2A")
                    && !urls[i].contains("cv64e2mCy7OGQCs7CPKpkDoSDtezuEj0iaAWY9icVghjkibXo6oGIfmtPaVFvJQwolSOC2XjFZ3FQ6fTETKXraeCQ")
                    ){
                HttpUtil.downloadFile(urls[i], FileUtil.file("d:/pic/"+i+".jpeg"));
            }
        }
    }
}
